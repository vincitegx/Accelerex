package com.neptunesoftware.accelerex.utils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import com.neptunesoftware.accelerex.exception.ResourceNotFoundException;
import com.neptunesoftware.accelerex.exception.UserNotFoundException;
import com.neptunesoftware.accelerex.user.User;
import com.neptunesoftware.accelerex.user.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

@Component
@Slf4j
public class AppUtils {
    @Autowired
    private UserRepository userRepository;


    public User getLoggedInUser() throws ResourceNotFoundException {
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        return userRepository.findByEmailAddress(((UserDetails)principal).getUsername())
                .orElseThrow(() -> new UserNotFoundException("Error getting logged in user"));
    }

    public List<String> splitStringIntoAList(String delimitedString){

        if (delimitedString!=null)
            return  Arrays.stream(delimitedString.split(",")).collect(Collectors.toList());
        return null;
    }

    /**
     * Deserialize JSON or XML data into an object of the specified target type.
     *
     * @param data        The JSON or XML data to be deserialized.
     * @param targetType The class representing the target type.
     * @param <T>         The type of the target object.
     * @return The deserialized object of the specified target type.
     */
    public  <T> T JSONOrXMLToObject(String data, Class<T> targetType) {
        T result = null;
        try {
            // Detect the data format (JSON or XML)
            boolean isJSON = data.trim().startsWith("{");

            // Initialize the appropriate object mapper
            ObjectMapper mapper = isJSON ? new ObjectMapper() : new XmlMapper();

            // Deserialize the data into the target type
            result = mapper.readValue(data, targetType);
        } catch (Exception e) {
            // Handle any exceptions that occur during deserialization
            e.printStackTrace();
        }
        return result;
    }

    public  String convertDateFormatToString(String inputDate, String sourceFormat, String neededFormat) throws ParseException {

        DateFormat originalFormat = new SimpleDateFormat(sourceFormat, Locale.ENGLISH);
        DateFormat targetFormat = new SimpleDateFormat(neededFormat);
        Date date = originalFormat.parse(inputDate);
        return targetFormat.format(date);
    }

    public  String ObjectToJsonString(Object object) {
        String jsonString = null;
        try {
            ObjectMapper mapper = new ObjectMapper();
            jsonString = mapper.writeValueAsString(object);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return jsonString;
    }



    public void log(String message) {
        log.info(message);
    }
    public void print(Object obj){
        try {
            log.info(new ObjectMapper().writeValueAsString(obj));
        }
        catch (Exception ex){
            ex.printStackTrace();
        }
    }
    public String generateAccountNumber() {
        Random random = new Random();
        StringBuilder otp = new StringBuilder();
        for (int i = 0; i < 10; i++) {
            otp.append(random.nextInt(4, 10));
        }
        return otp.toString();
    }

    public  String generateSerialNumber(String prefix) {
        Random rand = new Random();
        long x = (long)(rand.nextDouble()*100000000000000L);
        return  prefix + String.format("%014d", x);
    }


    public boolean isValidImage(String fileName) {

        String regex = "(.*/)*.+\\.(png|jpg|gif|bmp|jpeg|PNG|JPG|GIF|BMP|JPEG)$";
        Pattern p = Pattern.compile(regex);
        if (fileName == null) {
            return false;
        }
        Matcher m = p.matcher(fileName);
        return m.matches();
    }


    public boolean isValidEmail(String email) {
        String regex = "^[\\w-_\\.+]*[\\w-_\\.]\\@([\\w]+\\.)+[\\w]+[\\w]$";
        return email.matches(regex);
    }

    public String getFormattedNumber(String number){
        number=number.trim();
        if(number.startsWith("0"))
            number="+234"+number.substring(1);
        else if(number.startsWith("234"))
            number="+"+number;
        else {
            if (!number.startsWith("+")) {
                if (Integer.parseInt(String.valueOf(number.charAt(0))) > 0) {
                    number = "+234" + number;
                }
            }
        }
        return  number;
    }

    public Long generateRandomCode(){
        Random rnd = new Random();
        Long number = (long) rnd.nextInt(999999);
        return  number;
    }

    public String  getStringFromObject(Object o){

        try {
            ObjectMapper mapper = new ObjectMapper();
            return mapper.writeValueAsString(o);
        }catch (Exception ex){
            ex.printStackTrace();
            return null;
        }
    }


    public  Object getObjectFromString(String content, Class cls){

        try {
            ObjectMapper mapper = new ObjectMapper();
            return mapper.readValue(content,cls);
        }catch (Exception ex){
            ex.printStackTrace();
            return null;
        }
    }

    public String getReference() {
        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMddHHmmss");
        return now.format(formatter);
    }

    public ObjectMapper getObjectMapper(){
        return new ObjectMapper();
    }

    public String generateReference() {
        // Generate a random UUID
        UUID uuid = UUID.randomUUID();

        // Remove the hyphens and convert to uppercase
        String reference = uuid.toString().replaceAll("-", "").toUpperCase();

        // Return the first 10 characters
        return reference.substring(0, 10);
    }
}

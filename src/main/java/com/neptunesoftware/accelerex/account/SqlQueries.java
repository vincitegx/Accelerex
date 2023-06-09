package com.neptunesoftware.accelerex.account;

final class SqlQueries {

    public static final String NAME_ENQUIRY = """
            SELECT A.ACCT_NM
            			 FROM ACCOUNT A, CUST_IDENTIFICATION_INFO B, IDENTIFICATION_TYPE_REF C
            		WHERE  A.CUST_ID = B.CUST_ID(+) AND B.CUST_IDENT_ID(+) = C.IDENT_ID 
            		AND C.IDENT_ID = '461' AND A.ACCT_NO = ?
            """;

    public static final String IS_ACCOUNT_EXISTING = """
            SELECT FROM ACCOUNT WHERE ACCT_NO = ?
            """;
       public static final String TOKEN = """
""";
    public static final String GET_ACCOUNT_BY_USER = """
            """;
    public static final String SAVE_OTP = """
            INSERT INTO ALT_MAPP_DEVICE_OTP(PHONE_NUM,OTP) VALUES(?,?)
                   """;
    public static final String SAVE_SMS = """
            Insert into sms_messages(msg,sender,receiver,effective_dt,status, msgtype, msg_comment)
            		 VALUES(?,'HEAD OFFICE BRANCH',?, ?,'queued','OTP', 'OTP message queued for processing')
            """;
    public static final String OTP_EXPIRY_TIME = """
            SELECT EXPIRY_TIME FROM ALT_MAPP_DEVICE_OTP where PHONE_NUM = ? and OTP = ?
            """;
    public static final String SELECT_CUSTOMER_ID = """
            """;

    public static final String MULTIPLE_ACCOUNTS = """
            SELECT DISTINCT C.CUST_NM accountName, A.ACCT_NO accountNumber, a.PROD_CAT_TY accountType,  cc.crncy_cd_iso currency , d.LEDGER_BAL book_balance,
            					( SELECT (  das.cleared_bal + NVL ((SELECT SUM ( credit_appl_od_info_limit.approved_amt) 
            					FROM credit_appl_od_info, credit_appl_od_info_limit WHERE     credit_appl_od_info.credit_appl_od_info_id = 
            					credit_appl_od_info_limit.credit_appl_od_info_id AND das.deposit_acct_id = credit_appl_od_info.deposit_acct_id
            					AND credit_appl_od_info.expiry_dt > (SELECT TO_DATE (display_value,'DD/MM/YYYY') 
            					FROM ctrl_parameter WHERE param_cd = 'S02')), 0) - NVL ( (SELECT SUM (txn.txn_amt) FROM deposit_account_history txn 
            					WHERE txn.acct_no = das.acct_no AND txn.value_dt > (SELECT TO_DATE (display_value, 'DD/MM/YYYY')
            					FROM ctrl_parameter WHERE param_cd = 'S02') AND txn.dr_cr_ind = 'CR' AND txn.channel_id NOT IN '5'),0)  
            					- NVL ((SELECT reserved_fund FROM v_deposit_account_summary WHERE acct_no = das.acct_no),0)  
            					- NVL ((SELECT earmarked_fund FROM v_deposit_account_summary WHERE acct_no = das.acct_no), 0) 
            					- NVL ((SELECT cumulative_lien_amt  FROM v_deposit_account_summary WHERE acct_no = das.acct_no),0) 
            					- NVL ((SELECT SUM (arn.res_value) FROM v_account_restriction arn WHERE acct_id = das.deposit_acct_id
            					AND arn.rec_st = 'A' AND arn.res_sub_ty_cd NOT IN ('PRDRES49')),0) 
            					- NVL ((SELECT SUM (txn.tran_amt) FROM txn_journal txn WHERE     txn.acct_no = das.acct_no
            					AND txn.rec_st = 'U' AND txn.dr_cr_ind = 'DR'),0) 
            					- NVL ((SELECT dr_int_accrued FROM v_deposit_account_summary WHERE acct_no = das.acct_no),0) 
            					- NVL ((SELECT SUM (ej.actual_chrg_amt) FROM event_pending_charge_journal ej WHERE  ej.chrg_setlmnt_acct_id = das.deposit_acct_id
            					AND ej.rec_st = 'P'),0))  FROM Deposit_Account_Summary DAS 
            					WHERE DAS.ACCT_NO =   A.ACCT_NO) available_balance   
            					FROM account a, customer c, currency cc, Deposit_Account_Summary d
            					WHERE     a.cust_id = c.cust_id  AND A.REC_ST = 'A' AND CC.CRNCY_ID = A.CRNCY_ID AND A.ACCT_NO = D.ACCT_NO
            					AND A.CUST_ID =(SELECT CUST_ID FROM ACCOUNT WHERE ACCT_NO = ?)
            """;
    public static final String ACCOUNT_HISTORY_QUERY_1 = """
            select T3.REF_DESC, T1.tran_desc, T1.txn_amt, T1.stmnt_bal,
                   to_char(T1.sys_create_ts,'dd-MON-yyyy') as DATE_DESC ,T1.DR_CR_IND, T1.TRAN_REF_TXT
            from deposit_account_history T1 join ACCOUNT T2 on T1.acct_no = T2.acct_no
                                            left join PRODUCT_CATEGORY_REF T3 on T3.REF_KEY = T2.PROD_CAT_TY
            where ROWNUM <= 5 and t1.acct_no = ?   AND
                T1.sys_create_ts BETWEEN TO_DATE(?, 'yyyy-MM-dd') AND TO_DATE(?, 'yyyy-MM-dd')
            order by T1.sys_create_ts desc
            """;
    public static final String ACCOUNT_HISTORY_QUERY_2 = """
            select  *  FROM (select T3.REF_DESC, T1.tran_desc, T1.txn_amt, T1.stmnt_bal,
                   to_char(T1.sys_create_ts,'dd-MON-yyyy') as DATE_DESC ,T1.DR_CR_IND, T1.TRAN_REF_TXT
            from deposit_account_history T1 join ACCOUNT T2 on T1.acct_no = T2.acct_no
                                            left join PRODUCT_CATEGORY_REF T3 on T3.REF_KEY = T2.PROD_CAT_TY
            where t1.acct_no = ?
            order by T1.ROW_TS desc) where ROWNUM<= 5
            """;
    public static final String OTHER_HISTORY_INFO = """
            select t.TRAN_REF, t.FROM_ACCT_NUM, t.TRAN_RECEIVER, t.FROM_ACCT_NAME, t.TRAN_RECEIVER_NAME, t.BANK_NAME from ALT_QUICKTELLER t where TRAN_REF = ?
            """;
    public static final String SELECT_PASSCODE = """
            select accesspin from alt_mapp_device where acct_num = ?
            """;
    public static final String SELECT_EMAIL = """
            SELECT m.CONTACT FROM V_CUSTOMER_CONTACT_EMAIL m
            inner join  ACCOUNT a on m.CUST_ID = a.CUST_ID where a.ACCT_NO = ?
            """;
    public static final String SELECT_PHONE_NUM = """
            SELECT m.CONTACT FROM V_CUSTOMER_CONTACT_MOBILE_NO m inner join  ACCOUNT a on m.CUST_ID = a.CUST_ID where a.ACCT_NO = ?
               """;

    public static final String QUERY_PHONE_NUMBER = """
            SELECT m.CONTACT FROM V_CUSTOMER_CONTACT_MOBILE_NO m inner join  ACCOUNT a on m.CUST_ID = a.CUST_ID where a.ACCT_NO = ?
            """;
    public static final String QUERY_ACCOUNT_NUMBER = """
            """;
    public static final String SELECT_BVN = """
            select accesspin from alt_mapp_device where acct_num = ?
            """;
    public static final String UPDATE_ACCESS_PIN = """
            update alt_mapp_device set  accesspin = ? where acct_num = ?
            """;
    public static final String UPDATE_PASSWORD = """
            update alt_mapp_device set  password = ? where acct_num = ?
            """;
    public static final String GET_ACCOUNT_PASSWORD = """
            select password from alt_mapp_device where acct_num = ?
            """;
    public static final String UNLINK_DEVICE = """
            DELETE
            FROM
                alt_mapp_device
            WHERE
                acct_num = ?, device_uiid = ?
            """;
    public static final String ACCOUNT_INFO = """
            select  acct_no,	acct_type, title_1,
            				status, rim_no
            			from  	dp_acct
            				where  	acct_no = ?
            """;
    public static final String DELETE_BENEFICIARY = """
             delete from alt_quickteller_beneficiary where BEN_ID = ?
            """;
    public static final String INSERT_BENEFICIARY = """
            insert into alt_quickteller_beneficiary(Module_id, Sender_Acct_No, Ben_Acct_No, Ben_Acct_Name, Ben_Bank_Code, Ben_Bank_Name)
            values(?,?,?,?,?,?)
            """;
    public static final String SELECT_EXISTING_BENEFICIARY = """
            select Ben_Id, Ben_Acct_No, Ben_Acct_Name, Ben_Bank_Code, Ben_Bank_Name
            				from alt_quickteller_beneficiary
            				where Sender_Acct_No = ? and Ben_Acct_No = ?
            """;
    public static final String SELECT_BENEFICIARY = """
            select Ben_Id, Ben_Acct_No, Ben_Acct_Name, Ben_Bank_Code, Ben_Bank_Name
            from alt_quickteller_beneficiary where Sender_Acct_No = ?
            """;
    public static final String ACCOUNT_INFORMATION = """
            SELECT DISTINCT T1.CUST_NM, T1.CUST_NO,
                            (SELECT cm.contact FROM customer_contact_mode cm
                             WHERE cm.cust_id = T1.cust_id AND contact_mode_id IN (234, 235) AND ROWNUM = 1 ) EMAIL,
                            (SELECT c.contact FROM customer_contact_mode c
                             WHERE c.cust_id = T1.cust_id AND contact_mode_id IN (231, 236,237) AND ROWNUM = 1) PHONE_NUMBER,
                            A1.BIRTH_DT, T2.ACCT_NO, Y.IDENT_NO BVN, 1 KYC
            FROM CUSTOMER T1 , ACCOUNT T2, PERSON A1,
                 (  SELECT Q.IDENT_NO , Q.CUST_ID
                    FROM CUSTOMER_IDENTIFICATION Q, CUSTOMER_IDENTIFICATION_XREF QA
                    WHERE Q.CUST_IDENT_ID = QA.CUST_IDENT_XREF_ID
                      AND LENGTH(Q.IDENT_NO) = 11 ) Y
            WHERE T1.CUST_ID = T2.CUST_ID AND T2.PROD_CAT_TY = 'DP'
              AND T2.REC_ST = 'A' 	 AND T1.CUST_ID = A1.CUST_ID(+)
              AND T1.CUST_ID = Y.CUST_ID(+) AND T2.ACCT_NO  =   ?
            """;

    public static final String GET_USER_BY_ACCOUNT_NUMBER = """
            SELECT ACCT_NUM, PHONE_NUM, DEVICE_UIID, PASSWORD, ACCESSPIN, AUTHORITY, SYSTEM_TS as lastLogin FROM ALT_MAPP_DEVICE WHERE ACCT_NUM = ?
            """;
    private SqlQueries() {
    }
}

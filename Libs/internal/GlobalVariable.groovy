package internal

import com.kms.katalon.core.configuration.RunConfiguration
import com.kms.katalon.core.main.TestCaseMain


/**
 * This class is generated automatically by Katalon Studio and should not be modified or deleted.
 */
public class GlobalVariable {
     
    /**
     * <p></p>
     */
    public static Object OCSDK
     
    /**
     * <p></p>
     */
    public static Object baseUrl
     
    /**
     * <p>Profile default : 087875878815,087800190001
Profile backup : 087875878815,087800190001</p>
     */
    public static Object hp
     
    /**
     * <p></p>
     */
    public static Object app_id
     
    /**
     * <p></p>
     */
    public static Object nama
     
    /**
     * <p></p>
     */
    public static Object email
     
    /**
     * <p>Profile default : 191164
Profile backup : 191164</p>
     */
    public static Object pin
     
    /**
     * <p>Profile default : Nominal bayar test QRIS
Profile backup : Nominal bayar test QRIS</p>
     */
    public static Object qris_nominal_bayar
     
    /**
     * <p></p>
     */
    public static Object qris_nominal_tips
     
    /**
     * <p></p>
     */
    public static Object apk
     
    /**
     * <p></p>
     */
    public static Object ClientID_INDOLIFE
     
    /**
     * <p></p>
     */
    public static Object SecretID_INDOLIFE
     
    /**
     * <p></p>
     */
    public static Object ClienID_JOB2GO
     
    /**
     * <p></p>
     */
    public static Object SecretID_JOB2GO
     
    /**
     * <p></p>
     */
    public static Object ClientID_BOGASARI
     
    /**
     * <p></p>
     */
    public static Object SecretID_BOGASARI
     
    /**
     * <p></p>
     */
    public static Object ClientID_OTTOSTAMP
     
    /**
     * <p></p>
     */
    public static Object SecretID_OTTOSTAMP
     
    /**
     * <p></p>
     */
    public static Object ClientID_MOAJA
     
    /**
     * <p></p>
     */
    public static Object SecretID_MOAJA
     
    /**
     * <p></p>
     */
    public static Object ClientID_PARANJE
     
    /**
     * <p></p>
     */
    public static Object SecretID_PARANJE
     
    /**
     * <p></p>
     */
    public static Object nama_empty
     
    /**
     * <p></p>
     */
    public static Object email_empty
     
    /**
     * <p></p>
     */
    public static Object email_tanpa_dot
     
    /**
     * <p></p>
     */
    public static Object email_tanpa_at
     
    /**
     * <p></p>
     */
    public static Object nama_dengan_angka
     
    /**
     * <p></p>
     */
    public static Object CIMB_CASHOUT
     
    /**
     * <p></p>
     */
    public static Object url_CIMBcashout
     
    /**
     * <p></p>
     */
    public static Object appName
     
    /**
     * <p></p>
     */
    public static Object SECURE_PAGE
     
    /**
     * <p></p>
     */
    public static Object url_secure_page
     
    /**
     * <p></p>
     */
    public static Object referenceNumber
     
    /**
     * <p></p>
     */
    public static Object amount_securepage
     
    /**
     * <p></p>
     */
    public static Object Timestamp
     
    /**
     * <p></p>
     */
    public static Object AppsID
     
    /**
     * <p></p>
     */
    public static Object Signature
     
    /**
     * <p></p>
     */
    public static Object requestMethod
     
    /**
     * <p></p>
     */
    public static Object authHeader
     
    /**
     * <p></p>
     */
    public static Object merchantId
     
    /**
     * <p></p>
     */
    public static Object merchantName
     
    /**
     * <p></p>
     */
    public static Object merchantURL
     
    /**
     * <p></p>
     */
    public static Object successURL
     
    /**
     * <p></p>
     */
    public static Object failedURL
     
    /**
     * <p></p>
     */
    public static Object secretKey
     
    /**
     * <p></p>
     */
    public static Object hp_terblokir
     

    static {
        try {
            def selectedVariables = TestCaseMain.getGlobalVariables("default")
			selectedVariables += TestCaseMain.getGlobalVariables(RunConfiguration.getExecutionProfile())
            selectedVariables += TestCaseMain.getParsedValues(RunConfiguration.getOverridingParameters())
    
            OCSDK = selectedVariables['OCSDK']
            baseUrl = selectedVariables['baseUrl']
            hp = selectedVariables['hp']
            app_id = selectedVariables['app_id']
            nama = selectedVariables['nama']
            email = selectedVariables['email']
            pin = selectedVariables['pin']
            qris_nominal_bayar = selectedVariables['qris_nominal_bayar']
            qris_nominal_tips = selectedVariables['qris_nominal_tips']
            apk = selectedVariables['apk']
            ClientID_INDOLIFE = selectedVariables['ClientID_INDOLIFE']
            SecretID_INDOLIFE = selectedVariables['SecretID_INDOLIFE']
            ClienID_JOB2GO = selectedVariables['ClienID_JOB2GO']
            SecretID_JOB2GO = selectedVariables['SecretID_JOB2GO']
            ClientID_BOGASARI = selectedVariables['ClientID_BOGASARI']
            SecretID_BOGASARI = selectedVariables['SecretID_BOGASARI']
            ClientID_OTTOSTAMP = selectedVariables['ClientID_OTTOSTAMP']
            SecretID_OTTOSTAMP = selectedVariables['SecretID_OTTOSTAMP']
            ClientID_MOAJA = selectedVariables['ClientID_MOAJA']
            SecretID_MOAJA = selectedVariables['SecretID_MOAJA']
            ClientID_PARANJE = selectedVariables['ClientID_PARANJE']
            SecretID_PARANJE = selectedVariables['SecretID_PARANJE']
            nama_empty = selectedVariables['nama_empty']
            email_empty = selectedVariables['email_empty']
            email_tanpa_dot = selectedVariables['email_tanpa_dot']
            email_tanpa_at = selectedVariables['email_tanpa_at']
            nama_dengan_angka = selectedVariables['nama_dengan_angka']
            CIMB_CASHOUT = selectedVariables['CIMB_CASHOUT']
            url_CIMBcashout = selectedVariables['url_CIMBcashout']
            appName = selectedVariables['appName']
            SECURE_PAGE = selectedVariables['SECURE_PAGE']
            url_secure_page = selectedVariables['url_secure_page']
            referenceNumber = selectedVariables['referenceNumber']
            amount_securepage = selectedVariables['amount_securepage']
            Timestamp = selectedVariables['Timestamp']
            AppsID = selectedVariables['AppsID']
            Signature = selectedVariables['Signature']
            requestMethod = selectedVariables['requestMethod']
            authHeader = selectedVariables['authHeader']
            merchantId = selectedVariables['merchantId']
            merchantName = selectedVariables['merchantName']
            merchantURL = selectedVariables['merchantURL']
            successURL = selectedVariables['successURL']
            failedURL = selectedVariables['failedURL']
            secretKey = selectedVariables['secretKey']
            hp_terblokir = selectedVariables['hp_terblokir']
            
        } catch (Exception e) {
            TestCaseMain.logGlobalVariableError(e)
        }
    }
}
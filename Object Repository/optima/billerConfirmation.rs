<?xml version="1.0" encoding="UTF-8"?>
<WebServiceRequestEntity>
   <description></description>
   <name>billerConfirmation</name>
   <tag></tag>
   <elementGuidId>dd072a90-d762-4cfa-a810-06b4d96d31b1</elementGuidId>
   <selectorMethod>BASIC</selectorMethod>
   <useRalativeImagePath>false</useRalativeImagePath>
   <connectionTimeout>-1</connectionTimeout>
   <followRedirects>false</followRedirects>
   <httpBody></httpBody>
   <httpBodyContent>{
  &quot;text&quot;: &quot;{\n \&quot;merchantId\&quot;: \&quot;RTSM;;;;MG00000002121\&quot;,   \n \&quot;merchantName\&quot;: \&quot;BAYU ONLINE SHOP\&quot;,\n \&quot;phoneNumber\&quot;: \&quot;087875878815\&quot;,\n \&quot;trxId\&quot;: \&quot;AA1610000170501\&quot;,\n \&quot;amount\&quot;: 17500,\n \&quot;merchantURL\&quot;: \&quot;https://ottoapi.pactindo.com/ottocash-admin/ind/back\&quot;,\n \&quot;successURL\&quot;: \&quot;https://ottoapi.pactindo.com/ottocash-admin/ind/success\&quot;,\n \&quot;failedURL\&quot;: \&quot;https://ottoapi.pactindo.com/ottocash-admin/ind/failed\&quot;\n}\n&quot;,
  &quot;contentType&quot;: &quot;application/json&quot;,
  &quot;charset&quot;: &quot;UTF-8&quot;
}</httpBodyContent>
   <httpBodyType>text</httpBodyType>
   <httpHeaderProperties>
      <isSelected>true</isSelected>
      <matchCondition>equals</matchCondition>
      <name>Content-Type</name>
      <type>Main</type>
      <value>application/json</value>
      <webElementGuid>5fe68b3f-7816-42c7-b19c-0d448ff767e9</webElementGuid>
   </httpHeaderProperties>
   <httpHeaderProperties>
      <isSelected>true</isSelected>
      <matchCondition>equals</matchCondition>
      <name>Timestamp</name>
      <type>Main</type>
      <value>1508792287967</value>
      <webElementGuid>085b3fc9-9a74-428e-86fa-3bbdfd70e35d</webElementGuid>
   </httpHeaderProperties>
   <httpHeaderProperties>
      <isSelected>true</isSelected>
      <matchCondition>equals</matchCondition>
      <name>Apps-ID</name>
      <type>Main</type>
      <value>OTTOCASH</value>
      <webElementGuid>09d2957e-a677-4562-ba6b-c1047a147264</webElementGuid>
   </httpHeaderProperties>
   <httpHeaderProperties>
      <isSelected>true</isSelected>
      <matchCondition>equals</matchCondition>
      <name>Signature</name>
      <type>Main</type>
      <value>sAlq+jf11KS/eYpgZhEWookxpWpyIpbZWw0n32elqeQ=</value>
      <webElementGuid>a7725fc3-5f93-49e8-9bed-95fe75cd67bd</webElementGuid>
   </httpHeaderProperties>
   <katalonVersion>8.3.0</katalonVersion>
   <maxResponseSize>-1</maxResponseSize>
   <migratedVersion>5.4.1</migratedVersion>
   <restRequestMethod>POST</restRequestMethod>
   <restUrl>${GlobalVariable.url_secure_page}/billers/1.0.0/biller/confirmation</restUrl>
   <serviceType>RESTful</serviceType>
   <soapBody></soapBody>
   <soapHeader></soapHeader>
   <soapRequestMethod></soapRequestMethod>
   <soapServiceEndpoint></soapServiceEndpoint>
   <soapServiceFunction></soapServiceFunction>
   <socketTimeout>-1</socketTimeout>
   <useServiceInfoFromWsdl>true</useServiceInfoFromWsdl>
   <verificationScript>import static org.assertj.core.api.Assertions.*

import com.kms.katalon.core.testobject.RequestObject
import com.kms.katalon.core.testobject.ResponseObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webservice.verification.WSResponseManager

import groovy.json.JsonSlurper
import internal.GlobalVariable as GlobalVariable

RequestObject request = WSResponseManager.getInstance().getCurrentRequest()

ResponseObject response = WSResponseManager.getInstance().getCurrentResponse()</verificationScript>
   <wsdlAddress></wsdlAddress>
</WebServiceRequestEntity>

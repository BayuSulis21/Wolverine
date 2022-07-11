<?xml version="1.0" encoding="UTF-8"?>
<WebServiceRequestEntity>
   <description></description>
   <name>Locations By Type ID</name>
   <tag></tag>
   <elementGuidId>1751e18a-88c1-42a2-83c3-d5ce80342e9e</elementGuidId>
   <selectorMethod>BASIC</selectorMethod>
   <useRalativeImagePath>false</useRalativeImagePath>
   <connectionTimeout>-1</connectionTimeout>
   <followRedirects>false</followRedirects>
   <httpBody></httpBody>
   <httpBodyContent>{
  &quot;contentType&quot;: &quot;application/x-www-form-urlencoded&quot;,
  &quot;charset&quot;: &quot;UTF-8&quot;,
  &quot;parameters&quot;: []
}</httpBodyContent>
   <httpBodyType>x-www-form-urlencoded</httpBodyType>
   <httpHeaderProperties>
      <isSelected>true</isSelected>
      <matchCondition>equals</matchCondition>
      <name>Content-Type</name>
      <type>Main</type>
      <value>application/json</value>
      <webElementGuid>7771165a-e875-4d9b-9465-62a418786e52</webElementGuid>
   </httpHeaderProperties>
   <httpHeaderProperties>
      <isSelected>true</isSelected>
      <matchCondition>equals</matchCondition>
      <name>Authorization</name>
      <type>Main</type>
      <value>eyJ0eXAiOiJKV1QiLCJhbGciOiJSUzI1NiJ9.eyJhdWQiOiIxIiwianRpIjoiN2Y2ZGNjZTc4ZjE5NzU3MjY4ZmNhNzA1NTg2YTQyYmZjMDZlMzZjOTY2YWFkN2QzZGZkOGJiY2Y4NGYxNjdkZDUzMzE5NjUzZWIzNDE2OTEiLCJpYXQiOjE2NTExMzU1MjYuOTU5MzA2LCJuYmYiOjE2NTExMzU1MjYuOTU5MzA5LCJleHAiOjE2ODI2NzE1MjYuOTQ3NjU2LCJzdWIiOiIiLCJzY29wZXMiOlsicmV0cmlidXNpIl19.hJapLIBsGL6oIjw-Ec4XeLAyLLxgx5P__5GkMo2znKMZxSv--eG_ad-BspPTRfWyar-PVFefY7vNSODnyp7D02cAuW7w_vYp8tyJpWyvaZ_w5eLJshNBBiWxnnmPjKDVip3Ii6vjENaY81fG7CZVbvtsqOZbhv2PyZQba0QAdxGd1DP9DxbrulxzSVM2ENjAIt2_hXap3x975UNSOycfBlwM9-r2ntKckl2FzyFCv7I6n1VRTuvFuDne04jjRstTUuXjxxKD3-dGcPH72JPS1jD3ZjJpyyVUDVz3rdzqY8OydvyKELsulV3sZusxHH5OaIfazXdl7E5Q2kslw-doBioB-lsQoHYgd-ZaB3ULLblh8ozpqQnD3rYx_fA21QUdfEYAe8zj9uDIYNF-83ut4-bOoVYFeUEy7dCqiT6HwgsmjqZ0ivIYOTrbyBDA97VU7MvfBeSUMwXPD8TyIW3pelRdwEbas9ds0ILlYR-j7nUfrQQreG_rOqaRE7HijL8xISrIEinUAUHSdlkZdwyVBY4HepQDACYpceLGRpOyy332J6Qq3qZuoGs742i0eoU9U--tG_v7RnYVj_v_Rh70wMZ3PNvD_W_9YU5ru1Su8HyP9d1340rzM3K8hPFLEDJFeGEOeNM0yutbSepN7OL0L8k57pWh5Ahrp3wglHY-aUw</value>
      <webElementGuid>99f115b0-24fc-44e1-9d3d-5e070b8ea7d7</webElementGuid>
   </httpHeaderProperties>
   <katalonVersion>8.2.5</katalonVersion>
   <maxResponseSize>-1</maxResponseSize>
   <migratedVersion>5.4.1</migratedVersion>
   <restRequestMethod>GET</restRequestMethod>
   <restUrl>${GlobalVariable.url_retribusi}/retribution/v1/types/${type_id}/locations</restUrl>
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

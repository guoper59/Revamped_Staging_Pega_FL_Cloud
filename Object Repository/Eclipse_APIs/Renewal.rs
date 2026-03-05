<?xml version="1.0" encoding="UTF-8"?>
<WebServiceRequestEntity>
   <description></description>
   <name>Renewal</name>
   <tag></tag>
   <elementGuidId>181efb47-ec45-4258-bab6-e8b8d8ea67f4</elementGuidId>
   <selectorMethod>BASIC</selectorMethod>
   <smartLocatorEnabled>false</smartLocatorEnabled>
   <useRalativeImagePath>false</useRalativeImagePath>
   <autoUpdateContent>false</autoUpdateContent>
   <connectionTimeout>0</connectionTimeout>
   <followRedirects>true</followRedirects>
   <httpBody></httpBody>
   <httpBodyContent>{
  &quot;text&quot;: &quot;{\&quot;PolicyEnquiryFilter\&quot;:\n {\&quot;PolicyReference\&quot; : \&quot;${GlobalVariable.PolicyRef}\&quot;\n }\n}&quot;,
  &quot;contentType&quot;: &quot;application/json&quot;,
  &quot;charset&quot;: &quot;UTF-8&quot;
}</httpBodyContent>
   <httpBodyType>text</httpBodyType>
   <httpHeaderProperties>
      <isSelected>true</isSelected>
      <matchCondition>equals</matchCondition>
      <name>Ocp-Apim-Subscription-Key</name>
      <type>Main</type>
      <value>${GlobalVariable.SubcriptionKey}</value>
      <webElementGuid>b508386d-2ec2-4f32-b292-837865093d72</webElementGuid>
   </httpHeaderProperties>
   <httpHeaderProperties>
      <isSelected>true</isSelected>
      <matchCondition>equals</matchCondition>
      <name>Authorization:type</name>
      <type>Main</type>
      <value>OAuth 2.0</value>
      <webElementGuid>005a2f7b-5b7c-44de-9726-65b106b7be42</webElementGuid>
   </httpHeaderProperties>
   <httpHeaderProperties>
      <isSelected>true</isSelected>
      <matchCondition>equals</matchCondition>
      <name>Authorization</name>
      <type>Main</type>
      <value>Bearer ${GlobalVariable.AccessToken}</value>
      <webElementGuid>2cc654e1-8397-452a-a18f-72a045730511</webElementGuid>
   </httpHeaderProperties>
   <httpHeaderProperties>
      <isSelected>true</isSelected>
      <matchCondition>equals</matchCondition>
      <name>Authorization:grant_type</name>
      <type>Main</type>
      <value>Client Credentials</value>
      <webElementGuid>6df0f47b-1761-4258-b0e7-8360b84448bd</webElementGuid>
   </httpHeaderProperties>
   <httpHeaderProperties>
      <isSelected>true</isSelected>
      <matchCondition>equals</matchCondition>
      <name>Authorization:access_token_url</name>
      <type>Main</type>
      <value>${GlobalVariable.TokenGeneration}</value>
      <webElementGuid>0cff5ba7-987c-43c1-ab7d-4a6f72b21f92</webElementGuid>
   </httpHeaderProperties>
   <httpHeaderProperties>
      <isSelected>true</isSelected>
      <matchCondition>equals</matchCondition>
      <name>Authorization:state</name>
      <type>Main</type>
      <value></value>
      <webElementGuid>c83427a8-b56e-4a28-ada3-c4db3b8a8096</webElementGuid>
   </httpHeaderProperties>
   <httpHeaderProperties>
      <isSelected>true</isSelected>
      <matchCondition>equals</matchCondition>
      <name>Authorization:authorization_code</name>
      <type>Main</type>
      <value></value>
      <webElementGuid>bc357f0b-5300-43c8-b92c-acc8021e00cb</webElementGuid>
   </httpHeaderProperties>
   <httpHeaderProperties>
      <isSelected>true</isSelected>
      <matchCondition>equals</matchCondition>
      <name>Authorization:scope</name>
      <type>Main</type>
      <value></value>
      <webElementGuid>c1c6b4b7-fc18-4e0e-b20a-a486a43be70d</webElementGuid>
   </httpHeaderProperties>
   <httpHeaderProperties>
      <isSelected>true</isSelected>
      <matchCondition>equals</matchCondition>
      <name>Authorization:access</name>
      <type>Main</type>
      <value>${GlobalVariable.AccessToken}</value>
      <webElementGuid>9b2dc4f2-0795-493b-bfd8-b49c254b6c34</webElementGuid>
   </httpHeaderProperties>
   <httpHeaderProperties>
      <isSelected>true</isSelected>
      <matchCondition>equals</matchCondition>
      <name>Authorization:refesh_token</name>
      <type>Main</type>
      <value></value>
      <webElementGuid>e5783d86-9427-4eab-8cd2-04ad3735d8ca</webElementGuid>
   </httpHeaderProperties>
   <httpHeaderProperties>
      <isSelected>true</isSelected>
      <matchCondition>equals</matchCondition>
      <name>Authorization:oauth_consumer_key</name>
      <type>Main</type>
      <value>${GlobalVariable.ConsumerKey}</value>
      <webElementGuid>766f57ee-2ac6-4153-81c1-659f46703b97</webElementGuid>
   </httpHeaderProperties>
   <httpHeaderProperties>
      <isSelected>true</isSelected>
      <matchCondition>equals</matchCondition>
      <name>Authorization:oauth_consumer_secret</name>
      <type>Main</type>
      <value>${GlobalVariable.ConsumerSecret}</value>
      <webElementGuid>1e0773e6-a3ec-4cb4-bb87-e6569d057e70</webElementGuid>
   </httpHeaderProperties>
   <httpHeaderProperties>
      <isSelected>true</isSelected>
      <matchCondition>equals</matchCondition>
      <name>Authorization:token_type</name>
      <type>Main</type>
      <value>bearer</value>
      <webElementGuid>42526410-4e70-4cba-9ec4-dbedb0d2fdb5</webElementGuid>
   </httpHeaderProperties>
   <katalonVersion>9.7.2</katalonVersion>
   <maxResponseSize>0</maxResponseSize>
   <migratedVersion>5.4.1</migratedVersion>
   <path></path>
   <restRequestMethod>POST</restRequestMethod>
   <restUrl>${GlobalVariable.Renewal}</restUrl>
   <serviceType>RESTful</serviceType>
   <soapBody></soapBody>
   <soapHeader></soapHeader>
   <soapRequestMethod></soapRequestMethod>
   <soapServiceEndpoint></soapServiceEndpoint>
   <soapServiceFunction></soapServiceFunction>
   <socketTimeout>0</socketTimeout>
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

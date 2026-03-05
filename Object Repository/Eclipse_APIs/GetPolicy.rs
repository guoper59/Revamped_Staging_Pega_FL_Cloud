<?xml version="1.0" encoding="UTF-8"?>
<WebServiceRequestEntity>
   <description></description>
   <name>GetPolicy</name>
   <tag></tag>
   <elementGuidId>6c9c4043-dc44-44b4-b014-e6b44e8579b8</elementGuidId>
   <selectorMethod>BASIC</selectorMethod>
   <smartLocatorEnabled>false</smartLocatorEnabled>
   <useRalativeImagePath>false</useRalativeImagePath>
   <autoUpdateContent>false</autoUpdateContent>
   <connectionTimeout>0</connectionTimeout>
   <followRedirects>false</followRedirects>
   <httpBody></httpBody>
   <httpBodyContent>{
  &quot;text&quot;: &quot;{\n  \&quot;RequestWrapper\&quot;: {\n    \&quot;Action\&quot;: \&quot;Search\&quot;,\n    \&quot;Policies\&quot;: [\n      {\n        \&quot;Detail\&quot;: {\n          \&quot;PolicyRef\&quot;: \&quot;${GlobalVariable.PolicyRef}\&quot;\n        }\n      }\n    ],\n    \&quot;SBSId\&quot;: \&quot;SBSId_0\&quot;\n  }\n}&quot;,
  &quot;contentType&quot;: &quot;application/json&quot;,
  &quot;charset&quot;: &quot;UTF-8&quot;
}</httpBodyContent>
   <httpBodyType>text</httpBodyType>
   <httpHeaderProperties>
      <isSelected>true</isSelected>
      <matchCondition>equals</matchCondition>
      <name>Content-Type</name>
      <type>Main</type>
      <value>multipart/form-data</value>
      <webElementGuid>5eb9200c-d5ce-41a3-be57-8fad52901e14</webElementGuid>
   </httpHeaderProperties>
   <httpHeaderProperties>
      <isSelected>true</isSelected>
      <matchCondition>equals</matchCondition>
      <name>Ocp-Apim-Subscription-Key</name>
      <type>Main</type>
      <value>${GlobalVariable.SubcriptionKey}</value>
      <webElementGuid>ad6e271e-f394-46c0-baf0-75599d7bf4d9</webElementGuid>
   </httpHeaderProperties>
   <httpHeaderProperties>
      <isSelected>true</isSelected>
      <matchCondition>equals</matchCondition>
      <name>Authorization:type</name>
      <type>Main</type>
      <value>OAuth 2.0</value>
      <webElementGuid>b28db3f8-8a9b-4b7a-8b9e-3590c5a2e9bb</webElementGuid>
   </httpHeaderProperties>
   <httpHeaderProperties>
      <isSelected>true</isSelected>
      <matchCondition>equals</matchCondition>
      <name>Authorization</name>
      <type>Main</type>
      <value>Bearer ${GlobalVariable.AccessToken}</value>
      <webElementGuid>11d21526-55f2-41a5-943f-1246507d970f</webElementGuid>
   </httpHeaderProperties>
   <httpHeaderProperties>
      <isSelected>true</isSelected>
      <matchCondition>equals</matchCondition>
      <name>Authorization:grant_type</name>
      <type>Main</type>
      <value>Client Credentials</value>
      <webElementGuid>a454be75-8611-4c1a-9008-541858c13563</webElementGuid>
   </httpHeaderProperties>
   <httpHeaderProperties>
      <isSelected>true</isSelected>
      <matchCondition>equals</matchCondition>
      <name>Authorization:access_token_url</name>
      <type>Main</type>
      <value>${GlobalVariable.TokenGeneration}</value>
      <webElementGuid>a338691f-5631-4e2e-91a2-0442faa1cf80</webElementGuid>
   </httpHeaderProperties>
   <httpHeaderProperties>
      <isSelected>true</isSelected>
      <matchCondition>equals</matchCondition>
      <name>Authorization:state</name>
      <type>Main</type>
      <value></value>
      <webElementGuid>85699b76-9462-4015-b00e-221a86a7f422</webElementGuid>
   </httpHeaderProperties>
   <httpHeaderProperties>
      <isSelected>true</isSelected>
      <matchCondition>equals</matchCondition>
      <name>Authorization:authorization_code</name>
      <type>Main</type>
      <value></value>
      <webElementGuid>b34f9ed7-f4bc-4a92-9623-b8b49e6b8aea</webElementGuid>
   </httpHeaderProperties>
   <httpHeaderProperties>
      <isSelected>true</isSelected>
      <matchCondition>equals</matchCondition>
      <name>Authorization:scope</name>
      <type>Main</type>
      <value></value>
      <webElementGuid>a58496eb-c96d-4909-8dac-1a88417bd4a1</webElementGuid>
   </httpHeaderProperties>
   <httpHeaderProperties>
      <isSelected>true</isSelected>
      <matchCondition>equals</matchCondition>
      <name>Authorization:access</name>
      <type>Main</type>
      <value>${GlobalVariable.AccessToken}</value>
      <webElementGuid>8fc3724b-84c0-48d6-a711-38645abc61fe</webElementGuid>
   </httpHeaderProperties>
   <httpHeaderProperties>
      <isSelected>true</isSelected>
      <matchCondition>equals</matchCondition>
      <name>Authorization:refesh_token</name>
      <type>Main</type>
      <value></value>
      <webElementGuid>e5bc085b-bd23-428b-a80e-af84a302c432</webElementGuid>
   </httpHeaderProperties>
   <httpHeaderProperties>
      <isSelected>true</isSelected>
      <matchCondition>equals</matchCondition>
      <name>Authorization:oauth_consumer_key</name>
      <type>Main</type>
      <value>${GlobalVariable.ConsumerKey}</value>
      <webElementGuid>8572e44b-1ce6-48e6-8642-b78dd6749b38</webElementGuid>
   </httpHeaderProperties>
   <httpHeaderProperties>
      <isSelected>true</isSelected>
      <matchCondition>equals</matchCondition>
      <name>Authorization:oauth_consumer_secret</name>
      <type>Main</type>
      <value>${GlobalVariable.ConsumerSecret}</value>
      <webElementGuid>7f411adc-6201-41a6-a40b-c20a668b7b09</webElementGuid>
   </httpHeaderProperties>
   <httpHeaderProperties>
      <isSelected>true</isSelected>
      <matchCondition>equals</matchCondition>
      <name>Authorization:token_type</name>
      <type>Main</type>
      <value>bearer</value>
      <webElementGuid>dfb5bef3-42f4-4550-b594-c6d5038b5da9</webElementGuid>
   </httpHeaderProperties>
   <katalonVersion>9.5.0</katalonVersion>
   <maxResponseSize>0</maxResponseSize>
   <migratedVersion>5.4.1</migratedVersion>
   <path></path>
   <restRequestMethod>POST</restRequestMethod>
   <restUrl>${GlobalVariable.GetPolicy}</restUrl>
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

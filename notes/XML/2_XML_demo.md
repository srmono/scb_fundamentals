# Advanced XML with Bank Scenario

## 1. **Bank Data in XML (Base Example)**

Let’s represent a bank with customers and their accounts.

```xml
<Bank>
    <Customer id="C001">
        <Name>Ravi Kumar</Name>
        <Email>ravi.kumar@example.com</Email>
        <Accounts>
            <Account type="Savings">
                <AccountNumber>SB1001</AccountNumber>
                <Balance>50000</Balance>
            </Account>
            <Account type="Current">
                <AccountNumber>CA2001</AccountNumber>
                <Balance>200000</Balance>
            </Account>
        </Accounts>
    </Customer>

    <Customer id="C002">
        <Name>Priya Sharma</Name>
        <Email>priya.sharma@example.com</Email>
        <Accounts>
            <Account type="Savings">
                <AccountNumber>SB1002</AccountNumber>
                <Balance>75000</Balance>
            </Account>
        </Accounts>
    </Customer>
</Bank>
```

---

## 2. **Namespaces in Bank XML**

Namespaces avoid conflicts when different systems provide XML with same tag names.

```xml
<Bank xmlns:cus="http://bank.com/customer" 
      xmlns:acc="http://bank.com/account">
    <cus:Customer id="C001">
        <cus:Name>Ravi Kumar</cus:Name>
        <cus:Email>ravi.kumar@example.com</cus:Email>
        <acc:Accounts>
            <acc:Account type="Savings">
                <acc:AccountNumber>SB1001</acc:AccountNumber>
                <acc:Balance>50000</acc:Balance>
            </acc:Account>
        </acc:Accounts>
    </cus:Customer>
</Bank>
```

👉 Here we used two namespaces:

* `cus` → for customer details
* `acc` → for account details

---

## 3. **DTD (Document Type Definition)**

DTD validates structure but not data types.

```dtd
<!DOCTYPE Bank [
    <!ELEMENT Bank (Customer+)>
    <!ELEMENT Customer (Name, Email, Accounts)>
    <!ATTLIST Customer id ID #REQUIRED>
    <!ELEMENT Name (#PCDATA)>
    <!ELEMENT Email (#PCDATA)>
    <!ELEMENT Accounts (Account+)>
    <!ELEMENT Account (AccountNumber, Balance)>
    <!ATTLIST Account type (Savings|Current|Loan) #REQUIRED>
    <!ELEMENT AccountNumber (#PCDATA)>
    <!ELEMENT Balance (#PCDATA)>
]>
```

---

## 4. **XSD (XML Schema Definition)**

XSD is more powerful than DTD because it supports **data types** (like integer, string, date).

```xml
<xs:schema xmlns:xs="http://www.w3.org/2001/XMLSchema">

    <xs:element name="Bank">
        <xs:complexType>
            <xs:sequence>
                <xs:element name="Customer" maxOccurs="unbounded">
                    <xs:complexType>
                        <xs:sequence>
                            <xs:element name="Name" type="xs:string"/>
                            <xs:element name="Email" type="xs:string"/>
                            <xs:element name="Accounts">
                                <xs:complexType>
                                    <xs:sequence>
                                        <xs:element name="Account" maxOccurs="unbounded">
                                            <xs:complexType>
                                                <xs:sequence>
                                                    <xs:element name="AccountNumber" type="xs:string"/>
                                                    <xs:element name="Balance" type="xs:decimal"/>
                                                </xs:sequence>
                                                <xs:attribute name="type" use="required">
                                                    <xs:simpleType>
                                                        <xs:restriction base="xs:string">
                                                            <xs:enumeration value="Savings"/>
                                                            <xs:enumeration value="Current"/>
                                                            <xs:enumeration value="Loan"/>
                                                        </xs:restriction>
                                                    </xs:simpleType>
                                                </xs:attribute>
                                            </xs:complexType>
                                        </xs:element>
                                    </xs:sequence>
                                </xs:complexType>
                            </xs:element>
                        </xs:sequence>
                        <xs:attribute name="id" type="xs:ID" use="required"/>
                    </xs:complexType>
                </xs:element>
            </xs:sequence>
        </xs:complexType>
    </xs:element>
</xs:schema>
```

---

## 5. **XPath Queries**

XPath helps **extract data** from XML.

Example queries on our Bank XML:

* Get all customer names:

  ```xpath
  /Bank/Customer/Name
  ```
* Get balance of Ravi’s savings account:

  ```xpath
  /Bank/Customer[Name='Ravi Kumar']/Accounts/Account[@type='Savings']/Balance
  ```
* Get all account numbers:

  ```xpath
  //AccountNumber
  ```

---

## 6. **XSLT (Transform XML → HTML)**

Convert bank XML into a report (HTML).

```xml
<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet xmlns:xsl="http://www.w3.org/1999/XSL/Transform" version="1.0">

    <xsl:template match="/">
        <html>
            <body>
                <h2>Bank Customers</h2>
                <table border="1">
                    <tr>
                        <th>Customer Name</th>
                        <th>Email</th>
                        <th>Account Number</th>
                        <th>Balance</th>
                    </tr>
                    <xsl:for-each select="Bank/Customer">
                        <xsl:for-each select="Accounts/Account">
                            <tr>
                                <td><xsl:value-of select="../Name"/></td>
                                <td><xsl:value-of select="../Email"/></td>
                                <td><xsl:value-of select="AccountNumber"/></td>
                                <td><xsl:value-of select="Balance"/></td>
                            </tr>
                        </xsl:for-each>
                    </xsl:for-each>
                </table>
            </body>
        </html>
    </xsl:template>

</xsl:stylesheet>
```

👉 This will generate a neat **HTML table** with bank customers and their accounts.

---

## 7. **Validation Example**

If Ravi’s balance is written as `50k` instead of `50000`,

* **DTD validation** will **not catch** the error (because it doesn’t check data types).
* **XSD validation** will **catch** it (since `Balance` is restricted to `decimal`).

---

✅ So with this **Bank Scenario**, you now understand:

* Basic XML structure
* Namespaces
* DTD (structure validation)
* XSD (type validation)
* XPath (querying data)
* XSLT (transformation into HTML)


<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
    <xsl:template match="/">
        <html>
            <head>
                <META http-equiv="Content-Type" content="text/html; charset=UTF-8">
                <style type="text/css">
                    .winnerprovider-notification{ text-align: center;}
                    table {
                        border-collapse: separate;
                        border-spacing: 2em 1em;
                        }
                    h1, .footer{
                        color: rgb(245,123,32);
                        }
                </style>
            </head>
            <body class="winnerprovider-notification">
                <img src="https://drive.google.com/uc?id=0Bysr99hpvJ3hZHljb0ZUQW15a1U" height="20%" width="30%"/>
                <h1> Notificaci&oacute;n de Solicitud Ganadora </h1>
                <h3>La solicitud que realizo a la categor&iacute;, fue seleccionada como ganadora.</h3>
                <h4>Detalles de la solicitud realizada: </h4>

                <table align="center">
                    <tr>
                        <th> Categoría </th>
                        <th> Descripción </th>
                        <th> Cantidad </th>
                        <th> Dirección </th>
                        <th> Fecha límite </th>
                        <th> Precio base </th>
                    </tr>

                    <xsl:for-each select="requisitionInfo">
                        <tr align="center">
                            <td class="column"><xsl:value-of select="title"/></td>
                            <td class="column"><xsl:value-of select="description"/></td>
                            <td class="column"><xsl:value-of select="quantity"/></td>
                            <td class="column"><xsl:value-of select="shipping_address"/></td>
                            <td class="column"><xsl:value-of select="limit_date"/></td>
                            <td class="column"><xsl:value-of select="base_amount"/> </td>
                        </tr>
                    </xsl:for-each>
                </table>

                <h3> Los datos de la transacci&oacute;n son los siguientes: </h3>
                <table align="center">
                    <tr>
                         <th> N°Autorizaci&oacute;n </th><th> Nombre Cliente </th><th> N°Tarjeta </th><th> Precio Cancelado </th>

                    <xsl:for-each select="userInfo">
                        <tr align="center">
                            <td class="column"><xsl:value-of select="authorization"/></td>
                            <td class="column"><xsl:value-of select="card_account_name"/></td>
                            <td class="column"><xsl:value-of select="card_number"/></td>
                            <td class="column"><xsl:value-of select="amount"/> </td>
                        </tr>
                    </xsl:for-each>
                </table>
                <p> Gracias por utilizar Smartquote </p>
            </body>

            <footer>
                <div class="footer">
                    <h4> Pernix-Labs </h4>
                </div>
            </footer>
        </html>
    </xsl:template>
</xsl:stylesheet>
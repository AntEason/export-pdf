<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8"/>
    <title>MsgInfo</title>
    <style type="text/css">
        body{ width: 100%; }
        .title{
            background-color: aquamarine;
        }
        table{
            width: auto;
            border:1px solid #d9d9d9;
            border-collapse:collapse;
        }
        th,td{
            border:1px solid #d9d9d9;   /*为单元格单独设置边框*/
        }
    </style>
</head>
<body>
<table>
    <tbody>
    <tr>
        <td class="title" colspan="2">Message Identifier</td>
    </tr>
    <tr>
        <td>Message Preparation Application</td>
        <td>Applic.Interface</td>
    </tr>
    <tr>
        <td>Unique Message Idenntifier</td>
        <td>I ${content.message.sndrFinInstnld} 199 ${content.message.transactionReferenceNumber}</td>
    </tr>
    <tr>
        <td  class="title"  colspan="2">Message Header</td>
    </tr>
    <tr>
        <td>Status</td>
        <td></td>
    </tr>
    <tr>
        <td>Format</td>
        <td>Swift</td>
    </tr>
    <tr>
        <td>Identifier</td>
        <td>FIN</td>
    </tr>
    <tr>
        <td>Sender</td>
        <td>${content.message.sndrFinInstnld}</td>
    </tr>
    <tr>
        <td>LT</td>
        <td>A</td>
    </tr>
    <tr>
        <td>Receiver</td>
        <td>${content.message.rcvrFinInstnld}</td>
    </tr>
    <tr>
        <td>LT</td>
        <td>X</td>
    </tr>
    <tr>
        <td>Transaction Reference</td>
        <td>${content.message.transactionReferenceNumber}</td>
    </tr>
    <tr>
        <td>Related Reference</td>
        <td>${content.message.relatedReference}</td>
    </tr>
    <tr>
        <td>Priority</td>
        <td></td>
    </tr>
    <tr>
        <td>Monitoring</td>
        <td></td>
    </tr>
    <tr>
        <td>MUR</td>
        <td>${msgId}</td>
    </tr>
    <tr>
        <td>Translation Result Details</td>
        <td></td>
    </tr>
    <tr>
        <td>Sub-Format</td>
        <td>Input</td>
    </tr>
    <tr>
        <td>Expansion</td>
        <td></td>
    </tr>
    <tr>
        <td>Nature</td>
        <td>Financial</td>
    </tr>
    <tr>
        <td  class="title"  colspan="2">Sender / Receiver</td>
    </tr>
    <tr>
        <td>Sender Institution</td>
        <td>${correspondent}</td>
    </tr>
    <tr>
        <td>Expansion</td>
        <td></td>
    </tr>
    <tr>
        <td>Receiver Institution</td>
        <td>${correspondent}</td>
    </tr>
    <tr>
        <td>Expansion</td>
        <td></td>
    </tr>
    <tr>
        <td  class="title"  colspan="2">Message Text</td>
    </tr>
    <tr>
        <td colspan="2">
            <pre>:20:${content.message.transactionReferenceNumber}</pre>
            <pre>:21:${content.message.relatedReference}</pre>
            <pre>:79:${content.message.narrative}</pre>
        </td>
    </tr>
    </tbody>
</table>
</body>
</html>
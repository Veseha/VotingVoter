package votingvoter;

import java.util.Dictionary;
import java.util.HashMap;
import java.util.Map;

public class Const {

//    static public String oss_csv = ".\\CSV\\oss_bsc.csv";
//    static public String email_from_address = "sdm@company.kz";
//    static public String host_email = "192.168.1.1";
//    static public int host_email_port = 25;
    static public String server_address = "http://localhost:10000/";
    static public String page_qppw = "qppw/";
    static public String page_ppw = "ppw/";
    static  public  String page_edittask = "edittask/";
    static public String message_about_work = "" +
//            "\t<a href=\"%s\">Страница редактирования </a> <br>" +
//            "\t<a href=\"%s\">Страница работы </a><br>" +
            "<a href=\"%s\" target=\"_blank\" rel=\"noopener noreferrer\"><font style=\"font-family: Segoe UI, sans-serif, serif, &quot;EmojiFont&quot;;\" size=\"2\" face=\"Segoe UI,sans-serif\"><span style=\"font-size:10pt;\">Страница редактирования" +
            "</span></font><font style=\"font-family: Segoe UI, sans-serif, serif, &quot;EmojiFont&quot;;\" size=\"2\" face=\"Segoe UI,sans-serif\"><span style=\"font-size:10pt;\" lang=\"en-US\"></span></font></a>" +
            "<p style=\"Margin:0;-webkit-text-size-adjust:none;-ms-text-size-adjust:none;mso-line-height-rule:exactly;font-family:arial, 'helvetica neue', helvetica, sans-serif;line-height:21px;color:#333333;font-size:14px\">" +
            "<a href=\"%s\" target=\"_blank\" rel=\"noopener noreferrer\"><font style=\"font-family: Segoe UI, sans-serif, serif, &quot;EmojiFont&quot;;\" size=\"2\" face=\"Segoe UI,sans-serif\"><span style=\"font-size:10pt;\">Страница работы" +
            "</span></font><font style=\"font-family: Segoe UI, sans-serif, serif, &quot;EmojiFont&quot;;\" size=\"2\" face=\"Segoe UI,sans-serif\"><span style=\"font-size:10pt;\" lang=\"en-US\"></span></font></a>" +
            "<p style=\"Margin:0;-webkit-text-size-adjust:none;-ms-text-size-adjust:none;mso-line-height-rule:exactly;font-family:arial, 'helvetica neue', helvetica, sans-serif;line-height:21px;color:#333333;font-size:14px\">" +
            "\tСведения о работе: <br>" +
            "\tНазвание: %s <br> " +
            "\tCRQ: %s <br> " +
            "\tКоманда: %s <br> " +
            "\tИсполнитель: %s <br> " +
            "\tЗапланированная дата: %s <br> " +
            "\tДата проведения работы: %s <br> " +
            "\tСетевой элемент: %s <br> " +
            "\tТип сетевого элемента: %s <br> " +
            "\tГород: %s <br> " +
            "";

    static public String message_about_task = "" +
            "<a href=\"%s\" target=\"_blank\" rel=\"noopener noreferrer\"><font style=\"font-family: Segoe UI, sans-serif, serif, &quot;EmojiFont&quot;;\" size=\"2\" face=\"Segoe UI,sans-serif\"><span style=\"font-size:10pt;\">Страница редактирования" +
            "</span></font><font style=\"font-family: Segoe UI, sans-serif, serif, &quot;EmojiFont&quot;;\" size=\"2\" face=\"Segoe UI,sans-serif\"><span style=\"font-size:10pt;\" lang=\"en-US\"></span></font></a>" +
            "<p style=\"Margin:0;-webkit-text-size-adjust:none;-ms-text-size-adjust:none;mso-line-height-rule:exactly;font-family:arial, 'helvetica neue', helvetica, sans-serif;line-height:21px;color:#333333;font-size:14px\">" +

            "<a href=\"%s\" target=\"_blank\" rel=\"noopener noreferrer\"><font style=\"font-family: Segoe UI, sans-serif, serif, &quot;EmojiFont&quot;;\" size=\"2\" face=\"Segoe UI,sans-serif\"><span style=\"font-size:10pt;\">Страница работы и тасков" +
            "</span></font><font style=\"font-family: Segoe UI, sans-serif, serif, &quot;EmojiFont&quot;;\" size=\"2\" face=\"Segoe UI,sans-serif\"><span style=\"font-size:10pt;\" lang=\"en-US\"></span></font></a>" +
            "<p style=\"Margin:0;-webkit-text-size-adjust:none;-ms-text-size-adjust:none;mso-line-height-rule:exactly;font-family:arial, 'helvetica neue', helvetica, sans-serif;line-height:21px;color:#333333;font-size:14px\">" +
            "\tСведения о таске: <br>" +
            "\tНазвание: %s <br> " +
            "\tСетевой элемент: %s <br> " +
            "\tИсполнитель: %s <br> " +
            "\tДата проведения таска: %s <br> " +
            "\tСтатус: %s <br> " +
            "\t <br> " +

            "\tСведения о работе: <br>" +
            "\tНазвание: %s <br> " +
            "\tCRQ: %s <br> " +
            "\tКоманда: %s <br> " +
            "\tИсполнитель: %s <br> " +
            "\tЗапланированная дата: %s <br> " +
            "\tДата проведения работы: %s <br> " +
            "\tСетевой элемент: %s <br> " +
            "\tТип сетевого элемента: %s <br> " +
            "\tГород: %s <br> " +
            "";


    public static final int fixedRateForSendingEmails = 60000*3; // 1000 - 1sec, 60000 - 1min, 3600000 - 1hour, 86400000 - 1day
    public static final  String cron_shedule = "0 0 8 * * 1-5"; //"0 5,10,15,20,25,30,35,40,45,50,55 * * * 1-5"
    public static final  String cron_Period_of_planning_the_works = "0 0 8 15-31 12 1-5"; //"0 5,10,15,20,25,30,35,40,45,50,55 * * * 1-5"
    static public String message_template_1 = " <html lang=\"ru\"> <head>     <meta charset=\"UTF-8\">     <link rel=\"stylesheet\" href=\"../../../frontend/css/email.css\"> </head> <body> <div class=\"es-wrapper-color\" style=\"background-color:#F6F6F6\"><!--[if gte mso 9]>    <v:background xmlns:v=\"urn:schemas-microsoft-com:vml\" fill=\"t\">     <v:fill type=\"tile\" color=\"#f6f6f6\"></v:fill>    </v:background>   <![endif]-->    <table class=\"es-wrapper\" width=\"100%\" cellspacing=\"0\" cellpadding=\"0\" style=\"mso-table-lspace:0pt;mso-table-rspace:0pt;border-collapse:collapse;border-spacing:0px;padding:0;Margin:0;width:100%;height:100%;background-repeat:repeat;background-position:center top;background-color:#F6F6F6\">      <tr>       <td valign=\"top\" style=\"padding:0;Margin:0\">        <table class=\"es-header\" cellspacing=\"0\" cellpadding=\"0\" align=\"center\" style=\"mso-table-lspace:0pt;mso-table-rspace:0pt;border-collapse:collapse;border-spacing:0px;table-layout:fixed !important;width:100%;background-color:transparent;background-repeat:repeat;background-position:center top\">          <tr>           <td align=\"center\" style=\"padding:0;Margin:0\">            <table class=\"es-header-body\" cellspacing=\"0\" cellpadding=\"0\" bgcolor=\"#ffffff\" align=\"center\" style=\"mso-table-lspace:0pt;mso-table-rspace:0pt;border-collapse:collapse;border-spacing:0px;background-color:#FFFFFF;width:600px\">              <tr>               <td align=\"left\" style=\"padding:0;Margin:0;padding-top:20px;padding-left:20px;padding-right:20px\">                <table width=\"100%\" cellspacing=\"0\" cellpadding=\"0\" style=\"mso-table-lspace:0pt;mso-table-rspace:0pt;border-collapse:collapse;border-spacing:0px\">                  <tr>                   <td valign=\"top\" align=\"center\" style=\"padding:0;Margin:0;width:560px\">                    <table width=\"100%\" cellspacing=\"0\" cellpadding=\"0\" role=\"presentation\" style=\"mso-table-lspace:0pt;mso-table-rspace:0pt;border-collapse:collapse;border-spacing:0px\">                      <tr>                       <td class=\"h-auto\" height=\"43\" align=\"center\" style=\"padding:0;Margin:0\"><p style=\"Margin:0;-webkit-text-size-adjust:none;-ms-text-size-adjust:none;mso-line-height-rule:exactly;font-family:arial, 'helvetica neue', helvetica, sans-serif;line-height:25px;color:#333333;font-size:21px\"><strong>";
    static public String message_template_2 = "</strong></p></td>                      </tr>                    </table></td>                  </tr>                </table></td>              </tr>            </table></td>          </tr>        </table>        <table class=\"es-content\" cellspacing=\"0\" cellpadding=\"0\" align=\"center\" style=\"mso-table-lspace:0pt;mso-table-rspace:0pt;border-collapse:collapse;border-spacing:0px;table-layout:fixed !important;width:100%\">          <tr>           <td align=\"center\" style=\"padding:0;Margin:0\">            <table class=\"es-content-body\" cellspacing=\"0\" cellpadding=\"0\" bgcolor=\"#ffffff\" align=\"center\" style=\"mso-table-lspace:0pt;mso-table-rspace:0pt;border-collapse:collapse;border-spacing:0px;background-color:#FFFFFF;width:600px\">              <tr>               <td align=\"left\" style=\"padding:0;Margin:0;padding-top:20px;padding-left:20px;padding-right:20px\">                <table width=\"100%\" cellspacing=\"0\" cellpadding=\"0\" style=\"mso-table-lspace:0pt;mso-table-rspace:0pt;border-collapse:collapse;border-spacing:0px\">                  <tr>                   <td valign=\"top\" align=\"center\" style=\"padding:0;Margin:0;width:560px\">                    <table width=\"100%\" cellspacing=\"0\" cellpadding=\"0\" role=\"presentation\" style=\"mso-table-lspace:0pt;mso-table-rspace:0pt;border-collapse:collapse;border-spacing:0px\">                      <tr>                       <td align=\"left\" style=\"padding:0;Margin:0\">";
    static public String message_template_3 =   "<br></p></td>                      </tr>                    </table></td>                  </tr>                </table></td>              </tr>              <tr>               <td align=\"left\" style=\"padding:0;Margin:0;padding-top:20px;padding-left:20px;padding-right:20px\">                <table width=\"100%\" cellspacing=\"0\" cellpadding=\"0\" style=\"mso-table-lspace:0pt;mso-table-rspace:0pt;border-collapse:collapse;border-spacing:0px\">                  <tr>                   <td valign=\"top\" align=\"center\" style=\"padding:0;Margin:0;width:560px\">                    <table width=\"100%\" cellspacing=\"0\" cellpadding=\"0\" role=\"presentation\" style=\"mso-table-lspace:0pt;mso-table-rspace:0pt;border-collapse:collapse;border-spacing:0px\">                      <tr>                       <td align=\"center\" style=\"padding:0;Margin:0\"><p style=\"Margin:0;-webkit-text-size-adjust:none;-ms-text-size-adjust:none;mso-line-height-rule:exactly;font-family:arial, 'helvetica neue', helvetica, sans-serif;line-height:14px;color:#999999;font-size:14px\">Это сообщение было автоматически отправлено через корпоративную систему контроля за выполнением работ \"BeeTasks\", где вас указали как работника команды/отдела или исполнителя данной работы. Если произошла ошибка, пожалуйста обратитесь к вашему руководителю или vbeklemeshev@vshcorp.kz</p></td>                      </tr>                    </table></td>                  </tr>                </table></td>              </tr>            </table></td>          </tr>        </table></td>      </tr>    </table>   </div> </body>\n </html>";

}

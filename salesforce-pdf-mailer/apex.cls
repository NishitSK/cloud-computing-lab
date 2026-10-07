public class PdfMailer {

    public static void sendPdfFromUrl() {

        HttpRequest req = new HttpRequest();

        req.setEndpoint(
            'https://orgfarm-e363dfe4d7-dev-ed.develop.my.salesforce.com/sfc/p/aj000010tVST/a/aj000000NIfN/X.VcCQM.PCU2nflXqsWqFIR_WxoeE.vhz51PbnvswKE'
        );

        req.setMethod('GET');

        Http http = new Http();
        HttpResponse res = http.send(req);

        System.debug('Status: ' + res.getStatusCode());
        System.debug('Content-Type: ' + res.getHeader('Content-Type'));

        if (res.getStatusCode() == 200) {

            Messaging.EmailFileAttachment attachment =
                new Messaging.EmailFileAttachment();

            attachment.setFileName('Festival_Guide.pdf');
            attachment.setContentType('application/pdf');
            attachment.setBody(res.getBodyAsBlob());

            Messaging.SingleEmailMessage email =
                new Messaging.SingleEmailMessage();

            email.setToAddresses(
                new String[] { 'nishitsk2005@gmail.com' }
            );

            email.setSubject('Your Festival Guide is Ready!');

            email.setHtmlBody(
                '<h1>Your Festival Guide is Ready!</h1>' +
                '<p>Attached is your PDF guide.</p>'
            );

            email.setFileAttachments(
                new Messaging.EmailFileAttachment[] {
                    attachment
                }
            );

            Messaging.sendEmail(
                new Messaging.SingleEmailMessage[] {
                    email
                }
            );
        }
    }
}

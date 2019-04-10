package tranquvis.simplesmsremote.Sms;


public interface SmsServiceListener {
    void OnSmsSent(MyMessage sms, int resultCode);

    void OnSmsDelivered(MyMessage sms, int resultCode);
}

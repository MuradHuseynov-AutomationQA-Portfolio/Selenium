package testdata;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class TestData {
    public static class URLs {
        public static final String AUTH_URL = "https://app.3commas.io/en/auth/login";
        public static final String APP_URL = "https://app.3commas.io/d/apps/113";
    }
    public static class SignInTestData {
        public static final String SESSION_ID_KEY = "_session_id";
        public static final String SESSION_ID_VALUE = "99b4e86fb8a1a757e5aa432ad26489a8";
    }
    public static class InviteFriendsTestData{
        public static final String CODE = (String) LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyyMMddHHmmMS"));
        public static final String DESCRIPTION = "autotest";
    }
    public static class MyAccountsTestData{
        public static final String NAME = "autotest";
        public static final String API_KEY = "edrfhh5h53-2c435356-bbd8343b-6d346";
        public static final String API_SECRET = "176b9fc5-eda68b90-b9cc1123-efc82";
    }
}

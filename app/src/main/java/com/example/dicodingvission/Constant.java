package com.example.dicodingvission;

public class Constant {

    public static final String SUBSCRIPTION_KEY = "a636511130b545f39b069ab0d236b886";

    public class DateFormat {
        public static final String SERVER = "yyyy-MM-dd'T'HH:mm:ss";
    }

    public class Api {
        
        public static final String BASE_URL = "https://southeastasia.api.cognitive.microsoft.com/vision/v1.0/";
        public static final int TIMEOUT = 15;

        public class Params {
            public static final String KEY = "Ocp-Apim-Subscription-Key";
        }

        public class Code {
            public static final int SUCCESS = 200;
        }

        public class EndPoint {
            public class Auth {
                public static final String LOGIN = "auth";
            }
        }
    }

}

package com.example.dicodingvission.view.ocr;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class OCR {

    /**
     * language : en
     * orientation : Up
     * textAngle : 0
     * regions : [{"boundingBox":"21,16,304,451","lines":[{"boundingBox":"28,16,288,41","words":[{"boundingBox":"28,16,288,41","text":"NOTHING"}]},{"boundingBox":"27,66,283,52","words":[{"boundingBox":"27,66,283,52","text":"EXISTS"}]},{"boundingBox":"27,128,292,49","words":[{"boundingBox":"27,128,292,49","text":"EXCEPT"}]},{"boundingBox":"24,188,292,54","words":[{"boundingBox":"24,188,292,54","text":"ATOMS"}]},{"boundingBox":"22,253,297,32","words":[{"boundingBox":"22,253,105,32","text":"AND"},{"boundingBox":"144,253,175,32","text":"EMPTY"}]},{"boundingBox":"21,298,304,60","words":[{"boundingBox":"21,298,304,60","text":"SPACE."}]},{"boundingBox":"26,387,294,37","words":[{"boundingBox":"26,387,210,37","text":"Everything"},{"boundingBox":"249,389,71,27","text":"else"}]},{"boundingBox":"127,431,198,36","words":[{"boundingBox":"127,431,31,29","text":"is"},{"boundingBox":"172,431,153,36","text":"opinion."}]}]}]
     */

    @SerializedName("language")
    private String language;
    @SerializedName("orientation")
    private String orientation;
    @SerializedName("textAngle")
    private int textAngle;
    @SerializedName("regions")
    private List<Regions> regions;

    public String getLanguage() {
        return language;
    }

    public String getOrientation() {
        return orientation;
    }

    public int getTextAngle() {
        return textAngle;
    }

    public List<Regions> getRegions() {
        return regions;
    }

    public static class Regions {
        /**
         * boundingBox : 21,16,304,451
         * lines : [{"boundingBox":"28,16,288,41","words":[{"boundingBox":"28,16,288,41","text":"NOTHING"}]},{"boundingBox":"27,66,283,52","words":[{"boundingBox":"27,66,283,52","text":"EXISTS"}]},{"boundingBox":"27,128,292,49","words":[{"boundingBox":"27,128,292,49","text":"EXCEPT"}]},{"boundingBox":"24,188,292,54","words":[{"boundingBox":"24,188,292,54","text":"ATOMS"}]},{"boundingBox":"22,253,297,32","words":[{"boundingBox":"22,253,105,32","text":"AND"},{"boundingBox":"144,253,175,32","text":"EMPTY"}]},{"boundingBox":"21,298,304,60","words":[{"boundingBox":"21,298,304,60","text":"SPACE."}]},{"boundingBox":"26,387,294,37","words":[{"boundingBox":"26,387,210,37","text":"Everything"},{"boundingBox":"249,389,71,27","text":"else"}]},{"boundingBox":"127,431,198,36","words":[{"boundingBox":"127,431,31,29","text":"is"},{"boundingBox":"172,431,153,36","text":"opinion."}]}]
         */

        @SerializedName("boundingBox")
        private String boundingBox;
        @SerializedName("lines")
        private List<Lines> lines;

        public String getBoundingBox() {
            return boundingBox;
        }

        public List<Lines> getLines() {
            return lines;
        }

        public static class Lines {
            /**
             * boundingBox : 28,16,288,41
             * words : [{"boundingBox":"28,16,288,41","text":"NOTHING"}]
             */

            @SerializedName("boundingBox")
            private String boundingBox;
            @SerializedName("words")
            private List<Words> words;

            public String getBoundingBox() {
                return boundingBox;
            }

            public List<Words> getWords() {
                return words;
            }

            public static class Words {
                /**
                 * boundingBox : 28,16,288,41
                 * text : NOTHING
                 */

                @SerializedName("boundingBox")
                private String boundingBox;
                @SerializedName("text")
                private String text;

                public String getBoundingBox() {
                    return boundingBox;
                }

                public String getText() {
                    return text;
                }

            }
        }
    }
}

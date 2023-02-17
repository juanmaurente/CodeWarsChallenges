package Kyus5;

    public class HumanReadableTime {

/*Write a function, which takes a non-negative integer (seconds) as input and returns the time in a human-readable format (HH:MM:SS)

HH = hours, padded to 2 digits, range: 00 - 99
MM = minutes, padded to 2 digits, range: 00 - 59
SS = seconds, padded to 2 digits, range: 00 - 59
The maximum time never exceeds 359999 (99:59:59)
*/
        public HumanReadableTime() {
        }

        public static String makeReadable(int seconds) {

            var hourCalc = formatNumber((int) Math.floor(seconds/3600));
            var minCalc = formatNumber((int) Math.floor((seconds % 3600) / 60));
            var secCalc = formatNumber(seconds % 3600 % 60);

            return hourCalc+":"+minCalc+":"+secCalc;
        }
        public static String formatNumber(int number){
            return number < 10 ? "0" + String.valueOf(number) : String.valueOf(number);
        }

        /*
        * OTHER SOLUTIONS FROM CODEWARS
        *
        * public static String makeReadable(int seconds) {
            return String.format("%02d:%02d:%02d", seconds / 3600, (seconds / 60) % 60, seconds % 60);
          }
          *
          * public static String makeReadable(int seconds) {
                int timeHours = seconds / 3600;
                int timeMinutes = (seconds % 3600) / 60;
                int timeSeconds = seconds % 60;
                String timeString = String.format("%02d:%02d:%02d", timeHours, timeMinutes, timeSeconds);
                //thanks Bigtoes for help!
                return timeString;
              }
        * */

    }





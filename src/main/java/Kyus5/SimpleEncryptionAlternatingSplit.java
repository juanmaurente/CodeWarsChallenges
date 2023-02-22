package Kyus5;

public class SimpleEncryptionAlternatingSplit {

    /*
    * Implement a pseudo-encryption algorithm which given a string S and an integer N concatenates all the odd-indexed characters of S with all the even-indexed characters of S, this process should be repeated N times.

        Examples:

        encrypt("012345", 1)  =>  "135024"
        encrypt("012345", 2)  =>  "135024"  ->  "304152"
        encrypt("012345", 3)  =>  "135024"  ->  "304152"  ->  "012345"

        encrypt("01234", 1)  =>  "13024"
        encrypt("01234", 2)  =>  "13024"  ->  "32104"
        encrypt("01234", 3)  =>  "13024"  ->  "32104"  ->  "20314"
    * */

    public static String encrypt(final String text, final int n) {

        StringBuilder oddChars, evenChars;
        String result = text;

        for (int i = 0; i < n; i++) {
            oddChars = new StringBuilder();
            evenChars = new StringBuilder();
            for (int j = 0; j < result.length(); j++) {
                char c = result.charAt(j);
                if (j % 2 == 0) {
                    evenChars.append(c);
                } else {
                    oddChars.append(c);
                }
            }
            result = oddChars.toString() + evenChars.toString();
        }
        return result;
    }

    public static String decrypt(final String encryptedText, final int n) {
        if (encryptedText == null || encryptedText.isEmpty() || n < 1) {
            return encryptedText;
        }

        int mid = encryptedText.length() / 2;
        StringBuilder result = new StringBuilder(encryptedText.length());
        String evenChars = encryptedText.substring(0, mid);
        String oddChars = encryptedText.substring(mid);
        for (int i = 0; i < mid; i++) {
            result.append(oddChars.charAt(i)).append(evenChars.charAt(i));
        }
        if (encryptedText.length() % 2 == 1) {
            result.append(oddChars.charAt(oddChars.length() - 1));
        }
        for (int i = 1; i < n; i++) {
            result = new StringBuilder(decrypt(result.toString(), 1));
        }
        return result.toString();
    }

}

import lombok.*;


@ToString
@EqualsAndHashCode
public class InputFields {
    private static CharSequence firstNameKey;

    private static CharSequence lastNameKey;

    private static CharSequence emailNameFieldKey;

    private static CharSequence passwordFieldKey;

    private static CharSequence phoneFieldKey;

    private static CharSequence day;

    private static CharSequence month;

    private static CharSequence year;

    private static CharSequence sex;

    private static CharSequence loginEmailField;

    private static CharSequence loginPasswordField;

    public InputFields() {
    }

    public static CharSequence getSex() {
        return sex;
    }

    public static void setSex(CharSequence sex) {
        InputFields.sex = sex;
    }

    public static CharSequence getDay() {
        return day;
    }

    public static void setDay(String day) {
        InputFields.day = day;
    }

    public static CharSequence getMonth() {
        return month;
    }

    public static void setMonth(String month) {
        InputFields.month = month;
    }

    public static CharSequence getYear() {
        return year;
    }

    public static void setYear(String year) {
        InputFields.year = year;
    }

    public static CharSequence getFirstNameKey() {
        return firstNameKey;
    }

    public static void setFirstNameKey(String firstNameKey) {
        InputFields.firstNameKey = firstNameKey;
    }

    public static CharSequence getLastNameKey() {
        return lastNameKey;
    }

    public static void setLastNameKey(String lastNameKey) {
        InputFields.lastNameKey = lastNameKey;
    }

    public static CharSequence getEmailNameFieldKey() {
        return emailNameFieldKey;
    }

    public static void setEmailNameFieldKey(String emailNameFieldKey) {
        InputFields.emailNameFieldKey = emailNameFieldKey;
    }

    public static CharSequence getPasswordFieldKey() {
        return passwordFieldKey;
    }

    public static void setPasswordFieldKey(String passwordFieldKey) {
        InputFields.passwordFieldKey = passwordFieldKey;
    }

    public static CharSequence getPhoneFieldKey() {
        return phoneFieldKey;
    }

    public static void setPhoneFieldKey(String phoneFieldKey) {
        InputFields.phoneFieldKey = phoneFieldKey;
    }

    public static CharSequence getLoginEmailField() {
        return loginEmailField;
    }

    public static void setLoginEmailField(CharSequence loginEmailField) {
        InputFields.loginEmailField = loginEmailField;
    }

    public static CharSequence getLoginPasswordField() {
        return loginPasswordField;
    }

    public static void setLoginPasswordField(CharSequence loginPasswordField) {
        InputFields.loginPasswordField = loginPasswordField;
    }
}

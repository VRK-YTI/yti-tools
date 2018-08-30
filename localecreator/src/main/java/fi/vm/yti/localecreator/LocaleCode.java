package fi.vm.yti.localecreator;

public class LocaleCode {
    private String langLocale;
    private String transFi;
    private String transSv;
    private String transEn;

    public LocaleCode() {

    }

    public LocaleCode(String locale) {
        this.langLocale = locale;
    }

    public LocaleCode(String locale, String transFi, String transSv, String transEn) {
        this.langLocale = locale;
        this.transFi = transFi;
        this.transSv = transSv;
        this.transEn = transEn;
    }

    public String getLangLocale() {
        return langLocale;
    }

    public void setLangLocale(String lang) {
        this.langLocale = lang;
    }

    public String getTransFi() {
        return transFi;
    }

    public String getTransSv() {
        return transSv;
    }

    public String getTransEn() {
        return transEn;
    }

    public void setTransFi(String transFi) {
        this.transFi = transFi;
    }

    public void setTransSv(String transSv) {
        this.transSv = transSv;
    }

    public void setTransEn(String transEn) {
        this.transEn = transEn;
    }

}

package fi.vm.yti.localecreator;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class LocaleMerger {

    private static final String LOCALE_FI = "fi";
    private static final String LOCALE_SV = "sv";
    private static final String LOCALE_EN = "en";

    public List<LocaleCode> LocaleMerger() {

        List<LocaleCode> localeCodes = new ArrayList<>();

        // Hardcoded for 'fi', 'sv' and 'en' for now
        Locale locFi = new Locale(LOCALE_FI);
        Locale locSv = new Locale(LOCALE_SV);
        Locale locEn = new Locale(LOCALE_EN);

        Locale[] availableLocales = Locale.getAvailableLocales();
        try {
            for (Locale loc : availableLocales) {
                LocaleCode localeCode = new LocaleCode();

                localeCode.setLangLocale(loc.toLanguageTag());
                localeCode.setTransFi(loc.getDisplayName(locFi));
                localeCode.setTransSv(loc.getDisplayName(locSv));
                localeCode.setTransEn(loc.getDisplayName(locEn));
                localeCodes.add(localeCode);
            }
        } catch(Exception e) {
            throw new RuntimeException(e);
        }

        return localeCodes;
    }
}

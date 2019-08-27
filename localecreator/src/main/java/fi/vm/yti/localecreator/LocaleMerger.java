package fi.vm.yti.localecreator;

import java.util.ArrayList;
import java.util.Arrays;
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

        List<Locale> availableLocales = Arrays.asList(Locale.getAvailableLocales());
        List<String> isoLangs = Arrays.asList(Locale.getISOLanguages());

        availableLocales.forEach(loc -> {
            LocaleCode localeCode = new LocaleCode();
            localeCode.setLangLocale(loc.toLanguageTag());
            localeCode.setTransFi(loc.getDisplayName(locFi));
            localeCode.setTransSv(loc.getDisplayName(locSv));
            localeCode.setTransEn(loc.getDisplayName(locEn));
            localeCodes.add(localeCode);
        });

        /* Also check if there are ISO languages that are not available as Locales */
        isoLangs.forEach(lang -> {
            Locale loc = Locale.forLanguageTag(lang);
            if (!availableLocales.contains(loc)) {
                LocaleCode localeCode = new LocaleCode();
                localeCode.setLangLocale(loc.toLanguageTag());
                localeCode.setTransFi(loc.getDisplayName(locFi));
                localeCode.setTransSv(loc.getDisplayName(locSv));
                localeCode.setTransEn(loc.getDisplayName(locEn));
                localeCodes.add(localeCode);
            }
        });

        System.out.println("Size: " + localeCodes.size());

        return localeCodes;
    }
}

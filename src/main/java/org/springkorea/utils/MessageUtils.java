package org.springkorea.utils;

import java.util.Locale;

import org.springframework.context.MessageSourceResolvable;
import org.springframework.context.annotation.Scope;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.stereotype.Component;

@Component
@Scope("singleton")
public class MessageUtils {
	public static String getMessage(String key) {
		try {
			ResourceBundleMessageSource bean = new ResourceBundleMessageSource();
			bean.setBasename("messages");
			return bean.getMessage(key, null, Locale.getDefault());
		} catch (Exception e) {
			return "Unresolved key: " + key;
		}
	}

	public static String getMessage(MessageSourceResolvable resolvable) {
		try {
			ResourceBundleMessageSource bean = new ResourceBundleMessageSource();
			bean.setBasename("messages");
			return bean.getMessage(resolvable, Locale.getDefault());
		} catch (Exception e) {
			return "Unresolved resolvable: " + resolvable;
		}
	}
}

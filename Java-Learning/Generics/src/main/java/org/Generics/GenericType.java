package org.Generics;

import org.generics.exception.CustomizedException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Generic Type class to get the specific Enum object 
 * based on generic value
 * @author juilykumari
 */
public class GenericType<S>{
	private static final Logger logger = LoggerFactory.getLogger(GenericType.class);
	
	public static final GenericType<Status> STATUS =
      new GenericType<Status>(Status.class);

   public static final GenericType<Week> WEEK =
      new GenericType<Week>(Week.class);

   public static final GenericType<Currency> CURRENCY =
      new GenericType<Currency>(Currency.class);

   private final Class<S> javaType;

   public GenericType(Class<S> javaType) {
      this.javaType = javaType;
   }
   public Class<S> getJavaType() {
	return javaType;
   }

	public static <T> GenericType<?> parse(T s) throws CustomizedException {
		try {
			if (Status.getType(s)!=null) {
				return STATUS;
			} else if (Week.getType(s)!=null) {
				return WEEK;
			} else if (Currency.getType(s)!=null) {
				return CURRENCY;
			}
		} catch (SecurityException e) {
			throw new CustomizedException(e.getMessage());
		}
		return null;
	}
	
	public static void main(String[] args) {
		try {
			parse(1);
		} catch (CustomizedException e) {
			logger.error(e.getMessage());
		}
	}
}

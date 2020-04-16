package cn.bdu.edu.zl.Converter;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.core.convert.converter.Converter;
//Converter<S, T>
//S:source,��Ҫת����Դ������
//T:target,��Ҫת����Ŀ������
public class DateConverter implements Converter<String, Date> {

	public Date convert(String source) {
		try {
			// ���ַ���ת��Ϊ��������
			SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyy-MM-dd HH:mm:ss");
			Date date = simpleDateFormat.parse(source);

			return date;
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// ���ת���쳣�򷵻ؿ�
		return null;
	}
}

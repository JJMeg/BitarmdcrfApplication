package nlpir.lucene.cn.ictclas;

import nlpir.lucene.cn.ictclas.finersegmet.FinerTokenizer;
import org.apache.lucene.analysis.Analyzer;
import org.apache.lucene.analysis.Tokenizer;
import org.apache.lucene.analysis.synonym.SynonymGraphFilterFactory;
import org.apache.lucene.analysis.util.ClasspathResourceLoader;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * 
 * @author panhongyan
 *
 */
public class NLPIRTokenizerAnalyzer extends Analyzer {

	String data = null;
	int encoding = 1;
	String sLicenceCode = null;
	String userDict = null;
	boolean bOverwrite = false;

	public NLPIRTokenizerAnalyzer(String data, int encoding, String sLicenceCode, String userDict, boolean bOverwrite) {
		this.data = data;
		this.encoding = encoding;
		this.sLicenceCode = sLicenceCode;
		this.userDict = userDict;
		this.bOverwrite = bOverwrite;
	}

	@Override
	protected TokenStreamComponents createComponents(String fieldName) {
		Tokenizer tokenizer = new NLPIRTokenizer(this.data, this.encoding, this.sLicenceCode, this.userDict,
				this.bOverwrite);
		Map paramsMap = new HashMap();
		paramsMap.put("synonyms","synonyms.txt");
		SynonymGraphFilterFactory factory = new SynonymGraphFilterFactory(paramsMap);
		ClasspathResourceLoader loader = new ClasspathResourceLoader();

		try {
			factory.inform(loader);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return new TokenStreamComponents(tokenizer, factory.create(tokenizer));
	}


}

package nlpir.lucene.cn.ictclas.finersegmet;

import org.apache.lucene.analysis.Analyzer;
import org.apache.lucene.analysis.Tokenizer;

public class FinerTokenizerAnalyzer extends Analyzer {

	String data = null;
	int encoding = 1;
	String sLicenceCode = null;
	String userDict = null;
	boolean bOverwrite = false;


	public FinerTokenizerAnalyzer(String data, int encoding, String sLicenceCode, String userDict, boolean bOverwrite) {
		this.data = data;
		this.encoding = encoding;
		this.sLicenceCode = sLicenceCode;
		this.userDict = userDict;
		this.bOverwrite = bOverwrite;
	}

	@Override
	protected TokenStreamComponents createComponents(String fieldName) {
		final Tokenizer tokenizer = new FinerTokenizer(this.data, this.encoding, this.sLicenceCode, this.userDict,
				this.bOverwrite);
		return new TokenStreamComponents(tokenizer);
	}
}

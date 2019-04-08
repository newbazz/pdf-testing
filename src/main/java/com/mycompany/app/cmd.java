import com.testautomationguru.utility.PDFUtil;
class cmd
{
	public static void main(String[] args)
	{
		PDFUtil pdfUtil = new PDFUtil();
		// pdfUtil.getPageCount(args[0]);
		return pdfUtil.compare(args[0], args[1]);
	}
}
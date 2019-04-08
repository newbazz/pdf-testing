import com.testautomationguru.utility.PDFUtil;
class ComparePDFs
{
	public static void main(String[] args)
	{
		PDFUtil pdfUtil = new PDFUtil();
		// pdfUtil.getPageCount(args[0]);
		pdfUtil.setCompareMode(CompareMode.VISUAL_MODE);
		// boolean param = args[2];
		if(args[2]=="true"){
			pdfUtil.highlightPdfDifference(true);
			pdfUtil.setImageDestinationPath("./images/");
		}
		pdfUtil.compare(args[0], args[1]);
	}
}
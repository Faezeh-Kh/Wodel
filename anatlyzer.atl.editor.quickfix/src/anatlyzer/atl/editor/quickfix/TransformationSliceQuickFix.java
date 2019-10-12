package anatlyzer.atl.editor.quickfix;

import java.io.ByteArrayInputStream;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IMarker;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.jface.text.IDocument;

import anatlyzer.atl.analyser.generators.TransformationSlicer;
import anatlyzer.atl.editor.builder.AnATLyzerBuilder;
import anatlyzer.atl.editor.builder.AnalyserExecutor.AnalyserData;
import anatlyzer.atl.errors.Problem;
import anatlyzer.atl.quickfixast.QuickfixApplication;
import anatlyzer.ui.util.WorkbenchUtil;

public class TransformationSliceQuickFix extends AbstractAtlQuickfix {


	@Override
	public void apply(IDocument document) {
		try {
			AnalyserData analysisData = (AnalyserData) marker.getAttribute(AnATLyzerBuilder.ANALYSIS_DATA);

			// analysisData.computeProblemGraph(problem);
			
			String trafo = new TransformationSlicer(null).generateSlice(analysisData.getPath(), analysisData.getAnalyser());
		
			IFile f = WorkbenchUtil.getATLFile().getProject().getFile(WorkbenchUtil.getATLFile().getProjectRelativePath().removeFileExtension().addFileExtension("slice.atl"));
			if ( f.exists() ) {
				f.setContents(new ByteArrayInputStream(trafo.getBytes()), true, false, null);
			} else {
				f.create(new ByteArrayInputStream(trafo.getBytes()), true, null);
			}
		} catch (CoreException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override public void resetCache() { }
	
	@Override
	public String getAdditionalProposalInfo() {
		return "Slice transformation at error";
	}

	@Override
	public String getDisplayString() {
		return "Slice transformation";
	}

	@Override
	public boolean isApplicable(IMarker marker) {
		return true;
	}

	@Override
	public QuickfixApplication getQuickfixApplication() {
		throw new UnsupportedOperationException();
	}

}

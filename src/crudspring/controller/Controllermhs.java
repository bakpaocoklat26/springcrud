package crudspring.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;



import crudspring.model.mhs;
import crudspring.service.servicemhs;

@Controller
public class Controllermhs {

	
	private static final Logger logger = Logger
			.getLogger(Controllermhs.class);
	public Controllermhs() {
		System.out.println("MAHASISWA Controller()");
	}
	@Autowired
	private servicemhs servicemhsi;
	
	@RequestMapping(value = "/")
	public ModelAndView listMahasiswa(ModelAndView model) throws IOException {
		List<mhs> listMhs = servicemhsi.getAllMahasiswa();
		model.addObject("listMhs", listMhs);
		model.setViewName("home");
		return model;
	}
	
	@RequestMapping(value = "/tambah", method = RequestMethod.GET)
	public ModelAndView tambahMhs(ModelAndView model) {
		mhs mahasiswa = new mhs();
		model.addObject("mahasiswa", mahasiswa);
		model.setViewName("tambah");
		return model;
	}
	
	@RequestMapping(value = "/saveMhs", method = RequestMethod.POST)
	public ModelAndView saveMhs(@ModelAttribute mhs mahasiswa) {
		if (mahasiswa.getId() == 0) { // if employee id is 0 then creating the
			// employee other updating the employee
			servicemhsi.addMahasiswa(mahasiswa);
		} else {
			servicemhsi.updateMahasiswa(mahasiswa);
		}
		return new ModelAndView("redirect:/");
	}
	
	@RequestMapping(value = "/deleteMhs", method = RequestMethod.GET)
	public ModelAndView deleteMhs(HttpServletRequest request) {
		int mhsid = Integer.parseInt(request.getParameter("id"));
		servicemhsi.deleteMahasiswa(mhsid);
		return new ModelAndView("redirect:/");
	}
	
	@RequestMapping(value = "/editMhs", method = RequestMethod.GET)
	public ModelAndView editMhs(HttpServletRequest request) {
		int mhsid = Integer.parseInt(request.getParameter("id"));
		mhs mahasiswa = servicemhsi.getMahasiswa(mhsid);
		ModelAndView model = new ModelAndView("tambah");
		model.addObject("mahasiswa", mahasiswa);

		return model;
	}


}

package crudspring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;



import crudspring.dao.daomhs;
import crudspring.model.mhs;
import crudspring.service.servicemhs;

@Service
@Transactional
public class servicehmhsimp implements servicemhs {

	@Autowired
	private daomhs mhsdao;
	@Override
	@Transactional
	public void addMahasiswa(mhs mahasiswa) {
		// TODO Auto-generated method stub
		mhsdao.addMahasiswa(mahasiswa);
		
	}

	@Override
	@Transactional
	public List<mhs> getAllMahasiswa() {
		// TODO Auto-generated method stub
		return mhsdao.getAllMahasiswa();
	}

	@Override
	@Transactional
	public void deleteMahasiswa(Integer mahasiswaId) {
		// TODO Auto-generated method stub
		mhsdao.deleteMahasiswa(mahasiswaId);
		
	}

	@Override
	@Transactional
	public mhs getMahasiswa(int mahasiswaid) {
		// TODO Auto-generated method stub
		return mhsdao.getMahasiswa(mahasiswaid);
	}

	@Override
	@Transactional
	public mhs updateMahasiswa(mhs mahasiswa) {
		// TODO Auto-generated method stub
		return mhsdao.updateMahasiswa(mahasiswa);
	}
}

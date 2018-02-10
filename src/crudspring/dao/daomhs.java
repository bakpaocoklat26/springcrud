package crudspring.dao;

import java.util.List;

import crudspring.model.mhs;

public interface daomhs {
	
	public void addMahasiswa(mhs mahasiswa);

	public List<mhs> getAllMahasiswa();

	public void deleteMahasiswa(Integer mahasiswaId);

	public mhs getMahasiswa(int mahasiswaid);

	public mhs updateMahasiswa(mhs mahasiswa);
}


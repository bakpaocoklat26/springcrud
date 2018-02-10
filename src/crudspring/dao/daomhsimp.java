package crudspring.dao;

import java.util.List;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import crudspring.dao.daomhs;
import crudspring.model.mhs;

@Repository
public class daomhsimp implements daomhs {

	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public void addMahasiswa(mhs mahasiswa) {
		// TODO Auto-generated method stub
		sessionFactory.getCurrentSession().saveOrUpdate(mahasiswa);
		
	}

	@SuppressWarnings("unchecked")
	public List<mhs> getAllMahasiswa() {
		// TODO Auto-generated method stub
		return sessionFactory.getCurrentSession().createQuery("from mhs")
				.list();
	}

	@Override
	public void deleteMahasiswa(Integer mahasiswaId) {
		mhs mahasiswa = (mhs) sessionFactory.getCurrentSession().load(
				mhs.class, mahasiswaId);
		if (null != mahasiswa) {
			this.sessionFactory.getCurrentSession().delete(mahasiswa);
		}
		
	}

	@Override
	public mhs getMahasiswa(int mahasiswaid) {
		// TODO Auto-generated method stub
		return (mhs) sessionFactory.getCurrentSession().get(
				mhs.class, mahasiswaid);
	}

	@Override
	public mhs updateMahasiswa(mhs mahasiswa) {
		// TODO Auto-generated method stub
		sessionFactory.getCurrentSession().update(mahasiswa);
		return mahasiswa;
	}
}
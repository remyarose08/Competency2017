package com.shiftservices.repository.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.shiftservices.datatype.TimePeriod;
import com.shiftservices.entity.Comp2017;
import com.shiftservices.entity.ShiftEntry;
import com.shiftservices.repository.EmployeeShiftRepository;
import com.shiftservices.util.SysLogger;

@Transactional(propagation = Propagation.REQUIRED)
public class EmployeeShiftRepositoryImpl implements EmployeeShiftRepository {

	@PersistenceContext(unitName = "VolvoShiftServicesPU")
	private EntityManager entityManager;

	public void insertEmployeeShiftData(ShiftEntry shiftEntry) throws Exception {
		getEntityManager().persist(shiftEntry);
	}

	public void updateEmployeeShiftData(ShiftEntry shiftEntry) throws Exception {
		getEntityManager().merge(shiftEntry);
	}

	public EntityManager getEntityManager() {
		return entityManager;
	}

	@SuppressWarnings("unchecked")
	public List<ShiftEntry> findShiftDataForTimePeriod(TimePeriod timePeriod) {
		Query query = getEntityManager().createQuery("SELECT se FROM " + ShiftEntry.class.getSimpleName() + " se WHERE se.timePeriod = :timePeriod");
		query.setParameter("timePeriod", timePeriod);
		return (List<ShiftEntry>) query.getResultList();
	}
	
	@SuppressWarnings("unchecked")
	public List<ShiftEntry> findShiftDataForAll() {
		Query query = getEntityManager().createQuery("SELECT se FROM " + ShiftEntry.class.getSimpleName() + " se");
		return (List<ShiftEntry>) query.getResultList();
	}
	
	@SuppressWarnings("unchecked")
    public List<Comp2017> fetchBulkData() {
        Query query = getEntityManager().createQuery("SELECT se FROM " + Comp2017.class.getSimpleName() + " se");
        return (List<Comp2017>) query.getResultList();
    }

	@SuppressWarnings("unchecked")
	public boolean validateExistingShiftDataForEmployee(String employeeId, TimePeriod timePeriod) {
		try {
			Query query = getEntityManager().createQuery("SELECT se FROM " + ShiftEntry.class.getSimpleName() + " se WHERE se.timePeriod = :timePeriod and se.employeeId = :employeeId ");
			query.setParameter("timePeriod", timePeriod);
			query.setParameter("employeeId", employeeId);
			@SuppressWarnings("rawtypes")
			List resultList = query.getResultList();
			if (null != resultList && resultList.size() == 0) {
				return true;
			}
		} catch (NoResultException noResultException) {
			return true;
		}
		
		return false;
	}
	
	public void setEntityManager(EntityManager entityManager) {
		SysLogger.logMethod("setEntityManager", "ENTITY MANAGER"
				+ entityManager);
		this.entityManager = entityManager;
	}

}

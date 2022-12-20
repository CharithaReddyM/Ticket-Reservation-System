
package com.trs.miniproject.Model;

import java.sql.Date;
import java.util.HashMap;
import java.util.Map;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
@Entity
public class Train {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	
		private  Integer trainId;
		private  Integer capacity;
		private  Integer noOfComparments;
		private String trainSource;
		private String trainDestination ;
		private  Integer trainDate;
		public boolean isAvailable;
		public static Map<Integer,Integer> compartments = new HashMap<>();
		public Integer getTravellingDate() {
			return trainDate;
		}
		public void setTravellingDate(Integer travellingDate) {
			this.trainDate = travellingDate;
		}
		
		public Integer getTrainId() {
			return trainId;
		}
		public void setTrainId(Integer trainId) {
			this.trainId = trainId;
		}
		public Integer getCapacity() {
			return capacity;
		}
		public void setCapacity(Integer capacity) {
			this.capacity = capacity;
		}
		public Integer getNoOfComparments() {
			return noOfComparments;
		}
		public void setNoOfComparments(Integer noOfComparments) {
			this.noOfComparments = noOfComparments;
		}
		public String getTrainSource() {
			return trainSource;
		}
		public void setTrainSource(String trainSource) {
			this.trainSource = trainSource;
		}
		public String getTrainDestination() {
			return trainDestination;
		}
		public void setTrainDestination(String trainDestination) {
			this.trainDestination = trainDestination;
		}
		public boolean getIsAvailable() {
			return isAvailable;
		}
		public void setIsAvailable(boolean isAvailable) {
			this.isAvailable = isAvailable;
		}
		public Train(Integer trainId, Integer capacity, Integer noOfComparments, String trainSource,
				String trainDestination, boolean isAvailable,Integer TrainDate) {
			super();
			this.trainId = trainId;
			this.capacity = capacity;
			this.noOfComparments = noOfComparments;
			this.trainSource = trainSource;
			this.trainDestination = trainDestination;
			this.isAvailable = isAvailable;
			this.trainDate=trainDate;
		}
		public Train() {
			
		}
		
	}



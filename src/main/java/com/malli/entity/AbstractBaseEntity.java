package com.malli.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@MappedSuperclass
public abstract class AbstractBaseEntity<T> implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7911041006112140304L;
	
	public static final String SDEF = "char(10) default 'ACTIVE'";
    public static final String LDEF = "timestamp default current_timestamp "
                                       + "on update current_timestamp";
    
    @Id @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;
    
    @Temporal(TemporalType.TIMESTAMP)
    @Column(nullable=false, columnDefinition=LDEF)
    private Date lastUpdated;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(nullable=false, columnDefinition="timestamp default '0000-00-00 00:00:00'")
    private Date created;

    @Enumerated(EnumType.STRING)
    @Column(nullable=false, columnDefinition=SDEF)
    private Status status = Status.ACTIVE;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getLastUpdated() {
		return lastUpdated;
	}

	public void setLastUpdated(Date lastUpdated) {
		this.lastUpdated = lastUpdated;
	}

	public Date getCreated() {
		return created;
	}

	public void setCreated(Date created) {
		this.created = created;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

}

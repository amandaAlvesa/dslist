package com.dessuperior.dslist.entities;

import java.util.Objects;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_belonging")
public class Belonging {

	@EmbeddedId
	private BelongingPK Id = new BelongingPK();

	private Integer position;

	public Belonging() {
		super();
	}

	public Belonging(Game game, GameList list, Integer position) {
		this.Id.setGame(game);
		this.Id.setList(list);
		this.position = position;
	}

	public BelongingPK getId() {
		return Id;
	}

	public void setId(BelongingPK id) {
		Id = id;
	}

	public Integer getPosition() {
		return position;
	}

	public void setPosition(Integer position) {
		this.position = position;
	}

	@Override
	public int hashCode() {
		return Objects.hash(Id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Belonging other = (Belonging) obj;
		return Objects.equals(Id, other.Id);
	}

}

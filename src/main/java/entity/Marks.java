package entity;

public class Marks extends AbstractModelBean{

	/**
	 * 
	 */
	private static final long serialVersionUID = 5136003827305681145L;

    private Discipline discipline;
	private Integer id_term;
	private Integer id_pair_term_discipline;
	private Integer mark;
	private Integer id_student;

    public Marks(){

	}
	
	public Marks(Integer id_term, Integer id_pair_term_discipline, Integer mark, Integer id_student){
		super();
		this.id_term = id_term;
		this.id_pair_term_discipline = id_pair_term_discipline;
		this.mark = mark;
		this.id_student = id_student;
	}
	
	public Integer getIdTerm() {
		return id_term;
	}

	public void setIdTerm(Integer id) {
		this.id_term = id;
	}

	public Integer getId_pair_term_discipline() {
		return id_pair_term_discipline;
	}

	public void setId_pair_term_discipline(Integer id_pair_term_discipline) {
		this.id_pair_term_discipline = id_pair_term_discipline;
	}

	public Integer getMark() {
		return mark;
	}

	public void setMark(Integer mark) {
		this.mark = mark;
	}

	public Integer getId_student() {
		return id_student;
	}

	public void setId_student(Integer id_student) {
		this.id_student = id_student;
	}

    public Discipline getDiscipline() {
        return discipline;
    }

    public void setDiscipline(Discipline discipline) {
        this.discipline = discipline;
    }

}

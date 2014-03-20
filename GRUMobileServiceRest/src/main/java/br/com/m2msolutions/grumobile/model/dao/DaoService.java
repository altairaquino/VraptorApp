package br.com.m2msolutions.grumobile.model.dao;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import br.com.caelum.vraptor.ioc.Component;
import br.com.m2msolutions.grumobile.model.bean.Linha;
import br.com.m2msolutions.grumobile.model.bean.Tabela;
import br.com.m2msolutions.grumobile.model.bean.Veiculo;

@Component
public class DaoService {
	
	private static final String QUERY_LINHAS = "select b.busserviceid id, b.description codigo, b.name nome "
			+ " from busservice b "
			+ " where b.enabled";
	
	private static final String INSERT_ESCALA = "INSERT INTO vehiclebusserviceplanned(vehiclebusserviceplannedid,begintimestamp,endtimestamp,serviceid,vehicle_vehicleid,trip_program_id)"
			+ "	VALUES(nextval('sq_vehicle_bus_service_planned_id'), ?, ?, ?, ?, ?)";
	
	private static final String QUERY_VEICULOS = "select v.vehicleid id, v.vehiclecode codigo "
			+ " from vehicle v "
			+ " where v.enabled";
	
	private static final String QUERY_AUTENTICACAO = "select u.id, u.username from tb_user u "
			+ " where u.username = ?"
			+ " and u.password = md5(?)";
	
	private static final String QUERY_PROGRAMACAO = "select pg1.id "
			+ " from public.fw_program_day (?, Array[?]) as pg1";
	
	private static final String QUERY_TABELA =
			" SELECT " +
			" 		tp.bus_table as id, " +
			"       cast(tp.bus_table as varchar) as codigo " +
			" FROM " +
			"           tb_trip_program tp   " +
			" LEFT JOIN tb_program pg on " +
			"		pg.id = tp.program_id" +
			" WHERE " +
			"     tp.program_id = ? " +
			" GROUP BY " +
			"     tp.bus_table, " +
			"     pg.busservice_id";
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	public List<Linha> linhas() {
		return jdbcTemplate.query(QUERY_LINHAS, new BeanPropertyRowMapper<Linha>(Linha.class));
	}
	
	public List<Veiculo> veiculos() {
		return jdbcTemplate.query(QUERY_VEICULOS, new BeanPropertyRowMapper<Veiculo>(Veiculo.class));
	}
	
	public void registraEscala(Integer idLinha, Integer idVeiculo, Integer idTabela) {
		Object[] params = new Object[] {new Date(), getDateFinalDiaAtual(), idLinha, idVeiculo, idTabela};
		jdbcTemplate.update(INSERT_ESCALA, params);
	}
	
	public List<Tabela> tabelas(Integer idLinha) {
		Integer programId = getProgramacaoValida(new Date(), idLinha);
		Object[] params = new Object[] {programId};
		return jdbcTemplate.query(QUERY_TABELA, params, new BeanPropertyRowMapper<Tabela>(Tabela.class));
	}
	
	public Integer getProgramacaoValida(Date date, Integer linha) {
		Object[] params = new Object[] {date, linha};
		return jdbcTemplate.queryForInt(QUERY_PROGRAMACAO, params);
	}
	
	public Boolean autenticaUsuario(String usuario, String senha) {
		Object[] params = new Object[] {usuario, formataSenha(usuario, senha)};
		return !jdbcTemplate.query(QUERY_AUTENTICACAO, params, new BeanPropertyRowMapper<Tabela>(Tabela.class)).isEmpty();
	}
	
	public Date getDateFinalDiaAtual(){
		Calendar calendar = Calendar.getInstance();
		calendar.set(Calendar.HOUR_OF_DAY, 23);
		calendar.set(Calendar.MINUTE, 59);
		calendar.set(Calendar.SECOND, 59);
		calendar.set(Calendar.MILLISECOND, 999);
		
		return calendar.getTime();
	}
	
	private String formataSenha(String usuario, String senha){
		return senha+"{"+usuario+"}";
	}

}
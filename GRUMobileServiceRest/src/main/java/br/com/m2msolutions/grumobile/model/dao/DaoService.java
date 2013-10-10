package br.com.m2msolutions.grumobile.model.dao;

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
	
	private static final String QUERY_VEICULOS = "select v.vehicleid id, v.vehiclecode codigo "
			+ " from vehicle v "
			+ " where (v.company_id = ? or 0 = ?) and v.enabled";
	
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
	
	public List<Veiculo> veiculos(Integer empresa) {
		Object[] params = new Object[] {empresa, empresa};
		return jdbcTemplate.query(QUERY_VEICULOS, params, new BeanPropertyRowMapper<Veiculo>(Veiculo.class));
	}
	
	public List<Tabela> tabelas(Integer linha) {
		Integer programId = getProgramacaoValida(new Date(), linha);
		Object[] params = new Object[] {programId};
		return jdbcTemplate.query(QUERY_TABELA, params, new BeanPropertyRowMapper<Tabela>(Tabela.class));
	}
	
	public Integer getProgramacaoValida(Date date, Integer linha) {
		Object[] params = new Object[] {date, linha};
		return jdbcTemplate.queryForInt(QUERY_PROGRAMACAO, params);
	}
	

}
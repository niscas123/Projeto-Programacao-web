package interfaces;

import java.util.List;

/* Esta interface eh o cameleao do projeto, sao metodos 
 * genericos que serao utilizados para acessar o Banco de Dados
 */
public interface InterfaceGeral<R> {
	public void insert(R s);
	public R search(String s);
	public void update(R s);
	public void delete(R s);
	public List<R> Listen();

}

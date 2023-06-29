package it.polito.tdp.PremierLeague.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.jgrapht.Graph;
import org.jgrapht.Graphs;
import org.jgrapht.graph.DefaultWeightedEdge;
import org.jgrapht.graph.SimpleWeightedGraph;

import it.polito.tdp.PremierLeague.db.PremierLeagueDAO;

public class Model {
	private Graph<Match, DefaultWeightedEdge> graph;
	private PremierLeagueDAO dao;
	
	public Model() {
		
		this.graph = new SimpleWeightedGraph<>(DefaultWeightedEdge.class);
		this.dao = new PremierLeagueDAO();
	}
	
	//GRAFO PESATO NON ORIENTATO
	public Graph creaGrafo(int mese, int min) {
		this.graph = new SimpleWeightedGraph<>(DefaultWeightedEdge.class);

		
		Graphs.addAllVertices(this.graph, this.dao.listAllMatchesPerMonth(mese));
		
		for(Match m1: this.graph.vertexSet()) {
			for(Match m2 : this.graph.vertexSet()) {
				if(m1.getMatchID()!= m2.getMatchID()) {
					
					List<Integer> giocatori1 = this.dao.getListaPlayerByMatch(m1, min);
					List<Integer> giocatori2 = this.dao.getListaPlayerByMatch(m2, min);
					
					List<Integer> peso = new ArrayList<>();
					
					for(Integer i1 : giocatori1) {
						if(giocatori2.contains(i1)) {
							peso.add(i1);
						}
					}
					// RICORDATI
					if(peso.size()!=0) {
						Graphs.addEdge(this.graph, m1, m2, peso.size());
					}
				}
			}
		}
		
		
		return graph;
	}
	
	
	public List<DefaultWeightedEdge> listaArchi(){
		int peso = 0;
		
		List<DefaultWeightedEdge> result = new ArrayList<>();
		
		for(DefaultWeightedEdge e : this.graph.edgeSet()) {
			if(this.graph.getEdgeWeight(e)>peso) {
				peso = (int) this.graph.getEdgeWeight(e);
			}
		}
		
		for(DefaultWeightedEdge e : this.graph.edgeSet()) {
			if(this.graph.getEdgeWeight(e) == peso) {
				result.add(e);
			}
		}
		return result;
	}
	
	
	
}

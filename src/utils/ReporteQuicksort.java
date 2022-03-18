public class ReporteQuicksort {
    private String cond;
    private String metricas;
    private String tiempo;

    public ReporteQuicksort(String cond, String metricas, String tiempo){
        this.cond = cond;
        this.metricas = metricas;
        this.tiempo = tiempo;
    }

    public String toString(){
        
        String report = ("\n Ordenamiento : " + cond + metricas + "\n Tiempo del ordenamiento : " + tiempo + "\n");
        return report;
    }

}

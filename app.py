import jaydebeapi
def conectar();
    return jaydebeapi.connect(
    "org.h2.Driver",
    "jbdc:h2:file:.datos/biblioteca",
    ["sa", ""],
    "h2-2.5.252.jar"
    )
    def listar_peliculas():
        conn = conectar()
        curs = conn.cursor()
        curs.execute("Select p.id . p.titulo, p.anio, f.nombre FROM peliculas p JOIN
        franquicias f ON p.id_franquicia = f.id")

        filas = curs.fetchall()
        for f in filas:
            print(f"{f[0]}  - {f[1]} -{f[2]}) | Franquicia: {f"[03]"})
            curs.close()
            conn.close()
            if __name__ ==__main__":
                try:
                    listar_peliculas()
                    except Exception as e:
                        print("Aun no se puede leer:", e)
package controller;

public class DataUpdate {
    private String nim;
    private String status;
    private String alamat;
    private String tahunLahir;
    private String bulanLahir;
    private String tanggalLahir;
    private String angkatan;
    private String ipk;
    private String program;
    private String jenjang;
    private String kontak;
    private String semester;
    private String email;
    private String tempatLahir;
    private String tanggalNew;
    private String fullname;

    public DataUpdate(String nim, String status) {
        this.nim = nim;
        this.status = status;
    }
    
    public DataUpdate(String newTanggalLahir) {
        this.tanggalNew = newTanggalLahir;
    }

    public DataUpdate(String nim, String fullname, String alamat, String tahunLahir, String bulanLahir, String tanggalLahir, String angkatan, String ipk, String program, String jenjang, String kontak, String semester, String tempatLahir, String email, String newTTL) {
        this.nim = nim;
        this.fullname = fullname;
        this.alamat = alamat;
        this.tahunLahir = tahunLahir;
        this.bulanLahir = bulanLahir;
        this.tanggalLahir = tanggalLahir;
        this.angkatan = angkatan;
        this.ipk = ipk;
        this.program = program;
        this.jenjang = jenjang;
        this.kontak = kontak;
        this.semester = semester;
        this.tempatLahir = tempatLahir;
        this.email = email;
        this.tanggalNew = newTTL;
    }

    // Getters and setters for the new fields
    // ...

    public String getNim() {
        return nim;
    }

    public void setNim(String nim) {
        this.nim = nim;
    }
    
    public String getFullName() {
        return fullname;
    }
    
    public void setFullName() {
        this.fullname = fullname;
    }
    
    public String getTanggalNew() {
        return tanggalNew = tanggalNew;
    }
    
    public void setTanggalNew() {
        this.tanggalNew = tanggalNew;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getAlamat() {
        return alamat;
    }

    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }

    public String getTahunLahir() {
        return tahunLahir;
    }

    public void setTahunLahir(String tahunLahir) {
        this.tahunLahir = tahunLahir;
    }

    public String getBulanLahir() {
        return bulanLahir;
    }

    public void setBulanLahir(String bulanLahir) {
        this.bulanLahir = bulanLahir;
    }

    public String getTanggalLahir() {
        return tanggalLahir;
    }

    public void setTanggalLahir(String tanggalLahir) {
        this.tanggalLahir = tanggalLahir;
    }

    public String getAngkatan() {
        return angkatan;
    }

    public void setAngkatan(String angkatan) {
        this.angkatan = angkatan;
    }

    public String getIpk() {
        return ipk;
    }

    public void setIpk(String ipk) {
        this.ipk = ipk;
    }

    public String getProgram() {
        return program;
    }

    public void setProgram(String program) {
        this.program = program;
    }

    public String getJenjang() {
        return jenjang;
    }

    public void setJenjang(String jenjang) {
        this.jenjang = jenjang;
    }

    public String getKontak() {
        return kontak;
    }

    public void setKontak(String kontak) {
        this.kontak = kontak;
    }

    public String getSemester() {
        return semester;
    }

    public void setSemester(String semester) {
        this.semester = semester;
    }
    
    public String getTempatLahir() {
        return tempatLahir;
    }
    
    public void setTempatLahir(String tempatLahir) {
        this.tempatLahir = tempatLahir;
    }
    
    public String getEmail() {
        return email;
    }
    
    public void setEmail(String email) {
        this.email = email;
    }
}

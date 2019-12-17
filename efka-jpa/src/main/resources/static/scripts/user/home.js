function logout() {
    localStorage.clear();
    sessionStorage.clear();
    window.location.replace("../../../index.html");
}

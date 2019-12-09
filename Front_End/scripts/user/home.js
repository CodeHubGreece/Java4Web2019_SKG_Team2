function logout() {
    localStorage.clear();
    window.location.replace(ROOT_PATH + "/index.html")
}
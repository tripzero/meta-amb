SUMMARY = "Systemd service that brings up the CAN service at boot time"
AUTHOR = "Kevron Rees"
LICENSE = "Apache 2.0"
LIC_FILES_CHKSUM = "file://LICENSE;md5=fa818a259cbed7ce8bc2a22d35a464fc"
PR = "r1"

SRC_URI = "file://start-can \
           file://can-service \
           file://can.service \
           file://LICENSE \
          "

S = "${WORKDIR}"

do_install() {
        install -d ${D}/${bindir}
        install -d ${D}/${systemd_unitdir}/system
        install -d ${D}/etc
        install -m 0755 ${S}/start-can ${D}/${bindir}/start-can
        install -m 0755 ${S}/can.service ${D}/${systemd_unitdir}/system/can.service
        install -m 0755 ${S}/can-service ${D}/etc/can-service
}

FILES_${PN} = " \
               ${bindir}/start-can \
               ${systemd_unitdir}/system/can.service \
               /etc/can-service \
              "


RDEPENDS_${PN}_class-native = ""

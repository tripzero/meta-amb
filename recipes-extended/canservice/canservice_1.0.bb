SUMMARY = "Systemd service that brings up the CAN service at boot time"
AUTHOR = "Kevron Rees"
LICENSE = "Apache 2.0"
LIC_FILES_CHKSUM = "file://LICENSE;md5sum=foobar"
PR = "r1"

SRC_URI = "file://start-can \
           file://can-service \
           file://can.service \
          "

S = "${WORKDIR}"

do_install() {
        install -m 0755 ${S}/start-can ${D}/${bindir}/start-can
        install -m 0755 ${S}/can.service ${D}/lib/systemd/system/can.service
        install -m 0755 ${S}/can-service ${D}/etc/can-service
}


RDEPENDS_${PN}_class-native = ""

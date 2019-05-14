# README

Project requires directory to be created:
${user.home}/MovieSpotter_data/

And then files below to be placed inside:
- appConfig.properties (application config)
- guide.xml (tvProgramme data)(name can be set in appConfig)
- log4j.properties (log4j config)

appConfig supported options:
loadXml=true|false or yes|no - do or not xmlFile loading/parsing.
OnlyLoad = list of channel names to be load, case and heading/trailing chars sensible.
Ignore = when OnlyLoad is empty, all channels except listed here will be loaded
xmlfile=guide.xml - name of EPG data XML file. 




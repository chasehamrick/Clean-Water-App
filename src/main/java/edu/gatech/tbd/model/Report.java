package edu.gatech.tbd.model;

import edu.gatech.tbd.persistence.PersistenceManager;

public abstract class Report {
    
    /**
     * TODO Javadocs
     */
    int _reportNumber;
    String _reporter;
    double _locationLat;
    double _locationLong;
    String _dateTime;

    /**
     * Creates a new Water Report.
     */
    Report(int rNumber, String reporter, double locLat, double locLong, String date) {
        _reportNumber = rNumber;
        _reporter = reporter;
        _locationLat = locLat;
        _locationLong = locLong;
        _dateTime = date;
    }
    
    /**
     * Gets the report number.
     *
     * @return report number which identifies the report
     */
    public int getReportNumber() {
        return _reportNumber;
    }

    /**
     * Gets the user's name.
     *
     * @return user who created the report
     */
    public String getReporter() {
        return _reporter;
    }

    /**
     * Gets the water location.
     *
     * @return location of the report in (Lat, Long) format
     */
    String getLocation() {
        return "(" + _locationLat + ", " + _locationLong + ")";
    }

    /**
     * Gets the location's latitude.
     * @return latitude of report
     */
    public double getLocationLat() {
        return _locationLat;
    }

    /**
     * Gets the location's longitude.
     * @return longitude of report
     */
    public double getLocationLong() {
        return _locationLong;
    }

    /**
     * Gets the date the report was created.
     *
     * @return date of report
     */
    public String getDateTime() {
        return _dateTime;
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Report)) {
            return false;
        } else {
            Report other = (Report) o;
            return other._reportNumber == (_reportNumber)
                    && other._reporter.equals(_reporter)
                    && other._locationLat == _locationLat
                    && other._locationLong == _locationLong
                    && other._dateTime.equals(_dateTime);
        }
    }

    @Override
    public String toString() {
        return String.format("Report %02d (%f, %f) by %s", _reportNumber, _locationLat, _locationLong, _reporter);
    }
    
    public int hashCode() {
		return PersistenceManager.generateObjectHash(this);
	}
}

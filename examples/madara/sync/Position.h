/*********************************************************************
* Usage of this software requires acceptance of the SMASH-CMU License,
* which can be found at the following URL:
*
* https://code.google.com/p/smash-cmu/wiki/License
*********************************************************************/

/*********************************************************************
* Position.h - Declares the structures for a Position and a Region.
*********************************************************************/

#ifndef _POSITION_H
#define _POSITION_H

#include <iostream>     // std::dec
#include <sstream>      // std::ostringstream
#include <iomanip>        // std::setprecision

namespace SMASH
{
  namespace Utilities
  {
    /**
    * @brief Represents a two dimensional position, ignoring height.
    **/
    class Position
    {
    public:
      double longitude;
      double latitude;

      /**
      * Blank default constructor.
      **/
      Position() {}

      /** Constructor from data.
      * @param   newLat    The value for the latitude coordinate.
      * @param   newLong    The value for the longitude coordinate.
      **/
      Position(double newLat, double newLong) 
      {
        latitude = newLat;
        longitude = newLong;
      }

      Position(const Position& copy)
      {
        latitude = copy.latitude;
        longitude = copy.longitude;
      }

      const Position& operator=(const Position& right)
      {
        latitude = right.latitude;
        longitude = right.longitude;
        return *this;
      }

      /** Turns a position into a string.
      * @return a string of the form "lat,lon".
      **/
      std::string toString()
      {
        std::stringstream sstream;
        sstream << std::setprecision(10) << latitude << "," << longitude;
        return sstream.str();
      }
    };

    /**
    * @brief Represents a rectangular region defined by its top left and bottom right corners
    **/
    class Region
    {
    public:
      /**
      * Mark the corners of the Region
      */
      enum Corner { SOUTH_WEST, SOUTH_EAST, NORTH_WEST, NORTH_EAST };

      Position northWest;
      Position southEast;

      /** Constructor from data.
      * @param   newTopLeftCorner        The Position for the top left corner.
      * @param   newBottomRightCorner    The Position for the bottom right corner.
      **/
      Region(Position newNorthWestCorner, Position newSouthEastCorner)
      {
        northWest = newNorthWestCorner;
        southEast = newSouthEastCorner;
        invertRegionIfRequired();
      }

      Region(const Region& copy)
      {
        northWest = copy.northWest;
        southEast = copy.southEast;
        invertRegionIfRequired();
      }

      const Region& operator=(const Region& copy)
      {
        northWest = copy.northWest;
        southEast = copy.southEast;
        invertRegionIfRequired();
        return *this;
      }

      bool contains(const Position& test)
      {
        return ((test.longitude >= northWest.longitude) &&
          (test.longitude <= southEast.longitude) &&
          (test.latitude >= southEast.latitude) &&
          (test.latitude <= northWest.latitude));
      }

      ////////////////////////////////////////////////////////////////////////////////////////////
      // Returns the same region if its coordinates actually corresponded to the cardinal points.
      // If not, if inverts either the north-south latitudes, west-east longitudes, or both.
      // The end result is a region where the latitudes and longitudes match the names of the
      // object fields.
      ////////////////////////////////////////////////////////////////////////////////////////////
      void invertRegionIfRequired()
      {
        // Store the original values in temporary variables.
        Position originalNorthWest = this->northWest;
        Position originalSouthEast = this->southEast;

        // Check if we need a north-south latitude inversion.
        if(this->northWest.latitude < this->southEast.latitude)
        {
          // If the south latitude is greater than the north one, we recieved an inverted grid.
          // Switch to get the real north and south latitudes.
          //printf("Inverting north and south latitudes.\n");
          this->northWest.latitude = originalSouthEast.latitude;
          this->southEast.latitude = originalNorthWest.latitude;
        }

        // Check if we need a west-east longitude inversion.
        if(this->northWest.longitude > this->southEast.longitude)
        {
          // If the west longitude is greater than the east one, we recieved an inverted grid.
          // Switch to get the real west and east latitudes.
          //printf("Inverting west and east latitudes.\n");
          this->northWest.longitude = originalSouthEast.longitude;
          this->southEast.longitude = originalNorthWest.longitude;
        }
      }
    };
  }
}

#endif
